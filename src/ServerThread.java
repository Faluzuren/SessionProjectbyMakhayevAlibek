import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread{
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            DBManager manager = new DBManager();
            manager.connect();

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            PackageData packageData = null;
            ProductData productData = null;
            while ( (packageData=(PackageData)inputStream.readObject())!=null) {
                if(packageData.getOperationType().equals("REGISTRATION")) {
                    Guests guestsFromClient = packageData.getGuests();
                    manager.addGuests(guestsFromClient);
                }
                else if(packageData.getOperationType().equals("LISTGUESTS")) {
                    ArrayList<Guests> infoForClient = manager.getAllGuests();
                    PackageData toClient = new PackageData(infoForClient);
                    outputStream.writeObject(toClient);
                } else if(productData.getOperationType().equals("ADDPROD")) {
                    Products products = productData.getProducts();
                    manager.addProduct(products);

                }
            }

            inputStream.close();
            outputStream.close();
            socket.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

