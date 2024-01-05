import dto.*;
import entity.Position;
import entity.Ship;
import entity.ShipStatus;

import java.util.ArrayList;
import java.util.UUID;

public class Service {
    static void handleStartRequest(String clientId) {
        DataBase.StartStatus.put(clientId, true);
        String otherClientId = Service.getOtherClientId(clientId);

        if (otherClientId != null && DataBase.StartStatus.get(otherClientId)) {
            SocketServer.sendMessageToClient(clientId, new StartResponseDTO());
            SocketServer.sendMessageToClient(otherClientId, new StartResponseDTO());
        }
    }

    static String getOtherClientId(String clientId) {
        for (String id : DataBase.clientIds)
            if (!id.equals(clientId)) return id;
        return null;
    }

    public static String handleNewSignUp() {
        String clientId = UUID.randomUUID().toString();
        DataBase.clientIds.add(clientId);
        return clientId;
    }

    public static void handleSettingShips(String clientId, Ship[] ships) {
        ArrayList<ShipStatus> shipStatuses = new ArrayList<>();
        for (Ship ship : ships)
            shipStatuses.add(new ShipStatus(ship));

        DataBase.ShipsStatus.put(clientId, shipStatuses);
        String otherClientId = Service.getOtherClientId(clientId);
        if (DataBase.ShipsStatus.get(otherClientId) != null) {
            SocketServer.sendMessageToClient(otherClientId, new ReadyToPlayResponseDTO());
            SocketServer.sendMessageToClient(clientId, new ReadyToPlayResponseDTO());
        }
    }


    public static void handleAttack(String clientId, Position position) {
        //if (!DataBase.trun.equals(clientId)) return;

        String otherClientId = Service.getOtherClientId(clientId);

        Service.setTurn(otherClientId);
        for (ShipStatus shipStatus : DataBase.ShipsStatus.get(otherClientId)) {
            String result = shipStatus.handleAttack(position);

            if (result.equals("HIT_AND_DESTROY_SHIP")) {
                AttackResult attackResult = new AttackResult(true, true, position);
                SocketServer.sendMessageToClient(clientId, new AttackResultDTO(attackResult));
                SocketServer.sendMessageToClient(otherClientId, new AttackResultDTO(attackResult));

                if (Service.checkAllDestroyed(otherClientId)) {
                    SocketServer.sendMessageToClient(clientId, new GameResultRequestDTO(true));
                    SocketServer.sendMessageToClient(otherClientId, new GameResultRequestDTO(false));
                }
                return;
            } else if (result.equals("HIT")) {
                AttackResult attackResult = new AttackResult(true, false, position);
                SocketServer.sendMessageToClient(clientId, new AttackResultDTO(attackResult));
                return;
            }
            AttackResult attackResult = new AttackResult(false, false, position);
            SocketServer.sendMessageToClient(clientId, new AttackResultDTO(attackResult));
        }

    }


    public static boolean checkAllDestroyed(String clientId) {
        for (ShipStatus shipStatus : DataBase.ShipsStatus.get(clientId)) {
            if (!shipStatus.destroyed) return false;
        }
        return true;
    }


    private static void setTurn(String clientId) {
        SocketServer.sendMessageToClient(clientId, new TurnRequestDTO());
        DataBase.trun = clientId;
    }
}

