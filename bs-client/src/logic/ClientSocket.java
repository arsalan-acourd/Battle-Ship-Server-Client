package logic;

import dto.BaseRequest;
import dto.SignUpRequestDTO;
import entity.UserIdentifier;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.function.Function;

class ClientSocket {
    private Socket socket;
    private final long heartbeatDelayMillis = 5000;

    public ClientSocket(final String server, final int port, Function<Void, Void> authenticate) {
        Thread heartbeatThread = new Thread(() -> {
            while (true) {
                //send a test signal
                try {
                    if (socket != null) {
                        //socket.getOutputStream().write(666);
                    }
                    else connect(server, port, authenticate);
                    Thread.sleep(heartbeatDelayMillis);
                } catch (InterruptedException e) {
                    connect(server, port, authenticate);
                }
            }
        });
        heartbeatThread.start();
    }


    private void connect(String server, int port, Function<Void, Void> authenticate) {
        try {
            System.out.println("connect");
            socket = new Socket(server, port);
            authenticate.apply(null);
        } catch (IOException ignored) {
        }
    }


    public void listen(Function<BaseRequest, Void> function) {
        new Thread(() -> {
            while (true) {
                if (socket == null) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
                try {
                    ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                    BaseRequest packet = (BaseRequest) inputStream.readObject();
                    function.apply(packet);
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void sendMessage(BaseRequest message) throws IOException {
        System.out.println("sendMessage " + message.type);
        new ObjectOutputStream(socket.getOutputStream()).writeObject(message);
    }

}

