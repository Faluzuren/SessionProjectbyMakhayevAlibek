import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ListGuests extends Container {
    public static JTextArea text;
    private JButton buttonLIST;
    private JButton buttonBACK;

    public ListGuests() {
        setSize(500,400);
        setLayout(null);

        text = new JTextArea();
        text.setBounds(90, 50, 300, 150);
        add(text);

        buttonLIST = new JButton("LISTGUESTS");
        buttonLIST.setBounds(90, 220, 145, 30);
        buttonLIST.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageData pd = new PackageData("LISTGUESTS");
                Main.connect(pd);
            }
        });
        add(buttonLIST);

        buttonBACK = new JButton("BACK");
        buttonBACK.setBounds(245, 220, 145,30);
        buttonBACK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.menuWindow.setVisible(true);
                Main.frame.listWindow.setVisible(false);
            }
        });
        add(buttonBACK);



    }
}