import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ListGuests extends Container {
    public static JTextArea text;
    private JButton buttonLIST;
    private JButton buttonBACK;

    public ListGuests() {
        setSize(1200,1000);
        setLayout(null);

        text = new JTextArea();
        text.setBounds(450, 300, 300, 150);
        add(text);

        buttonLIST = new JButton("LISTGUESTS");
        buttonLIST.setBounds(520, 500, 145, 30);
        buttonLIST.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageData pd = new PackageData("LISTGUESTS");
                Main.connect(pd);
            }
        });
        add(buttonLIST);

        buttonBACK = new JButton("BACK");
        buttonBACK.setBounds(520, 600, 145,30);
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