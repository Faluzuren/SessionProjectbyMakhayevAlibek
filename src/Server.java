import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8100);

            while(true) {
                System.out.println("Waiting client");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

