import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    public static MainFrame frame;

    public static void connect(PackageData pd) {
        try {
            Socket socket = new Socket("127.0.0.1", 8100);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            if (pd.getOperationType().equals("REGISTRATION")) {
                outputStream.writeObject(pd);
            } else if (pd.getOperationType().equals("LISTGUESTS")) {
                outputStream.writeObject(pd);
                PackageData InfoFromServer = (PackageData) inputStream.readObject();
                ArrayList<Guests> arrayListFromServer = InfoFromServer.getGuest();
                String s = "";

                for (int i = 0; i < arrayListFromServer.size(); i++) {
                    s += arrayListFromServer.get(i) + "\n";
                }

                ListGuests.text.append(s);
            } else if (pd.getOperationType().equals("SIGNIN")) {
                outputStream.writeObject(pd);
            }
            inputStream.close();
            outputStream.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        frame = new MainFrame();
        frame.setVisible(true);
    }
}