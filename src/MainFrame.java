import javax.swing.*;
import java.io.IOException;

public class MainFrame extends JFrame {
    public static MainMenu menuWindow;
    public static AddUser AddWindow;
    public static ListGuests listWindow;
    public static AccessWindow AccessWindow;
    public static ShopWindow shopWindow;

    public MainFrame() {
        setSize(1200, 1000);
        setTitle("Internet Store");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuWindow = new MainMenu();
        menuWindow.setLocation(0,0);
        add(menuWindow);

        AddWindow = new AddUser();
        AddWindow.setLocation(0, 0);
        AddWindow.setVisible(false);
        add(AddWindow);

        listWindow = new ListGuests();
        listWindow.setLocation(0,0);
        listWindow.setVisible(false);
        add(listWindow);

        AccessWindow = new AccessWindow();
        AccessWindow.setLocation(0,0);
        AccessWindow.setVisible(false);
        add(AccessWindow);

        shopWindow = new ShopWindow();
        shopWindow.setLocation(0,0);
        shopWindow.setVisible(false);
        add(shopWindow);

    }
}
