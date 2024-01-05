import dto.BaseRequest;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.ArrayList;

public class SocketServer {
    static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();

    static public void run() {
        try {
            ServerSocket server = new ServerSocket(3000, 2, InetAddress.getByName("localhost"));
            while (true) {
                try {
                    ClientHandler clientHandler = new ClientHandler(server.accept());
                    SocketServer.clientHandlers.add(clientHandler);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendMessageToClient(String clientId, BaseRequest message){
        for (ClientHandler clientHandler : SocketServer.clientHandlers) {
            if(clientHandler.clientId.equals(clientId)){
                System.out.println("send message to : " + clientId);
                clientHandler.sendMessage(message);
            }
        }

    }
}
