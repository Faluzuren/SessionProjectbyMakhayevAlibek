import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AccessWindow extends Container {
    private JLabel loginLabel;
    private JLabel passwordLabel;

    private JTextField loginText;
    private JPasswordField passwordField;

    private JButton signIn;
    private JButton back;


    public AccessWindow() {
        setSize(800, 600);
        setLayout(null);

        loginLabel = new JLabel("Login");
        loginLabel.setBounds(90,60,60,30);
        add(loginLabel);

        loginText = new JTextField();
        loginText.setBounds(150, 60, 150, 30);
        add(loginText);


        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(90,100,60,30);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 150, 30);
        add(passwordField);

        signIn = new JButton("Sign in");
        signIn.setBounds(90, 140, 210, 30);
        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageData pd = new PackageData("SIGNIN");
                Main.connect(pd);
            }
        });
        add(signIn);

        back = new JButton("BACK");
        back.setBounds(90, 300, 210, 30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.menuWindow.setVisible(true);
                Main.frame.AccessWindow.setVisible(false);
            }
        });
        add(back);
    }



}
