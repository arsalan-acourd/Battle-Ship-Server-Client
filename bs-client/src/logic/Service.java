package logic;

import UI.GameFrame;
import UI.LandingPage;
import UI.Shipsetter;
import dto.*;

import entity.Position;
import entity.Ship.Ship;
import entity.UserIdentifier;

import java.io.IOException;


public class Service {

    static private ClientSocket clientSocket = null;
    static private String userId;

    public static void run() {
        Service.clientSocket = new ClientSocket("localhost", 3000, (ignored) -> {
            System.out.println("authenticate");
            return null;
        });

        Service.clientSocket.listen((BaseRequest response) -> {
            switch (response.type) {
                case "SIGN_UP":
                    userId = ((UserIdentifier) response.value).userId;
                    break;
                case "START":
                    LandingPage.getInstance().close();
                    Shipsetter.getInstance().open();
                    break;
                case "READY_TO_PLAY":
                    GameFrame.getInstance().open();
                    Shipsetter.getInstance().close();
                    break;
                case "ATTACK_RESULT":
                    AttackResult result_of_attack = (AttackResult) response.value;
                    if (result_of_attack.hit && result_of_attack.destroy) {
//                        show result.ship on clinetboard
                    }else if(result_of_attack.hit) {
                    // show result.position on client board(damaged)
                    }else {
                    // show result.position on client board(undamaged)
                    }
                    break;

                case "GAME_RESULT":
                    GameResultRequestDTO result_of_game = (GameResultRequestDTO) response;
                    if ((Boolean) result_of_game.value){
                        // result win for clientid
                        // result lose for otherclientid
                    }
                    else {
                        // result win for otherclientid
                        // result lose for clientid
                    }
                    break;
                case "TURN":
                    // show turn on ui for client and lock for otherclient
                    break;
                case "ATTACK":
                   AttackResult attackResult = (AttackResult) response.value;
                   if ((Boolean) attackResult.hit){
                       //show on board for otherclientid(damaged) attackresult.position
                   }
                   else {
                       // show on board for otherclientid(undamaged) attackresult.position
                   }
                    break;
            }
            return null;
        });
    }


    public static void login() {
        try {
            Service.clientSocket.sendMessage(new LoginRequestDTO(userId));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void signUp() {
        try {
            Service.clientSocket.sendMessage(new SignUpRequestDTO());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void start(){
        try {
            Service.clientSocket.sendMessage(new StartRequestDTO());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void settingShips(Ship[] ships){
        try {
            Service.clientSocket.sendMessage(new SettingShipsDTO(ships));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void attackShips(Position position){
        try {
            Service.clientSocket.sendMessage(new AttackRequestDTO(position));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void turn(){
        try {
            Service.clientSocket.sendMessage(new TurnRequestDTO());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void submit(String name){
        try {
            Service.clientSocket.sendMessage(new SubmitRequestDTO(name));
        } catch (IOException e) {
            e.printStackTrace();
    }
}
    }


