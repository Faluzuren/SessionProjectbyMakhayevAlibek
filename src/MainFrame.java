import javax.swing.*;

public class MainFrame extends JFrame {
    public static MainMenu menuWindow;
    public static AddUser AddWindow;
    public static ListGuests listWindow;
    public static AccessWindow AccessWindow;

    public MainFrame(){
        setSize(500, 400);
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

    }
}
