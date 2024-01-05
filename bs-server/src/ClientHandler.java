
import dto.BaseRequest;
import dto.SignUpResponseDTO;
import entity.Position;
import entity.Ship;
import entity.UserIdentifier;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler {
    Socket socket;
    public String clientId;

    public ClientHandler(Socket socket){
        System.out.println("new client connected");
        this.socket = socket;
        this.listen();
    }

    public void listen() {
        new Thread(() -> {
            while (true) {
                try {
                    ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                    BaseRequest packet = (BaseRequest) inputStream.readObject();
                    //System.out.println(packet.type);

                    if (packet.type.equals("LOGIN")) {
                        UserIdentifier value = (UserIdentifier) packet.value;
                        this.clientId = value.userId;
                    } else if (packet.type.equals("SIGN_UP")) {
                        this.clientId = Service.handleNewSignUp();
                        this.sendMessage(new SignUpResponseDTO(this.clientId));
                    } else if (packet.type.equals("START")) {
                        Service.handleStartRequest(clientId);
                    } else if (packet.type.equals("SETTING_SHIPS")) {
                        Service.handleSettingShips(clientId, (Ship[]) packet.value);
                    } else if (packet.type.equals("ATTACK")) {
                        Service.handleAttack(clientId, (Position) packet.value);
                    } else if (packet.type.equals("TURN")) {
                        if (DataBase.trun == null){
                            DataBase.trun = clientId;
                        }
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }).start();

    }

    public void sendMessage(BaseRequest message) {
//        new Thread(() -> {
        try {
            new ObjectOutputStream(socket.getOutputStream()).writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        }).start();

    }
}
