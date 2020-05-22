import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends Container {
    private JButton regBut;
    private JButton listBut;
    private JButton accessBut;
    private JButton exitBut;
    private JButton siteBut;

    public MainMenu(){
        setSize(500, 400);
        setLayout(null);

        regBut = new JButton("REGISTRATION");
        regBut.setBounds(100, 80, 300, 30);
        regBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.menuWindow.setVisible(false);
                Main.frame.AddWindow.setVisible(true);
            }
        });
        add(regBut);

        listBut = new JButton("LIST GUESTS");
        listBut.setBounds(100, 120, 300, 30);
        listBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.menuWindow.setVisible(false);
                Main.frame.listWindow.setVisible(true);

            }
        });
        add(listBut);

        accessBut = new JButton("SIGN IN");
        accessBut.setBounds(100,160,300,30);
        accessBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.menuWindow.setVisible(false);
                Main.frame.AccessWindow.setVisible(true);
            }

        });
        add(accessBut);

        siteBut = new JButton("ENTER SITE");
        siteBut.setBounds(100,200,300,30);
        siteBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.menuWindow.setVisible(false);
                Main.frame.shopWindow.setVisible(true);
            }

        });
        add(siteBut);


        exitBut = new JButton("EXIT");
        exitBut.setBounds(100, 240, 300, 30);
        exitBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitBut);



    }
}
