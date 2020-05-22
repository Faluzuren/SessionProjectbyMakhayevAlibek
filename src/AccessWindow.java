import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccessWindow extends Container {
    private JLabel loginLabel;
    private JLabel passwordLabel;

    private JTextField loginText;
    private JPasswordField passwordField;

    private JButton signIn;
    private JButton back;


    public AccessWindow() {
        setSize(1200, 1000);
        setLayout(null);

        loginLabel = new JLabel("Login");
        loginLabel.setBounds(450,300,60,30);
        add(loginLabel);

        loginText = new JTextField();
        loginText.setBounds(500, 300, 160, 30);
        add(loginText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(450,340,60,30);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(510, 340, 150, 30);
        add(passwordField);

        signIn = new JButton("Sign in");
        signIn.setBounds(450, 380, 210, 30);
        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nickname = loginText.getText().trim();
                String password = String.valueOf( passwordField.getText()).trim();

                if(!nickname.equals("") && !password.equals("")) {
                        loginUser(nickname, password);
                } else {
                    System.out.println("Login and password is empty");
                }
            }
        });
        add(signIn);


        back = new JButton("BACK");
        back.setBounds(450, 500, 210, 30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.menuWindow.setVisible(true);
                Main.frame.AccessWindow.setVisible(false);
            }
        });
        add(back);
    }

    private void loginUser(String nickname, String password) {
        DBManager dbManager = new DBManager();
        Guests guests = new Guests();
        guests.setNickName(nickname);
        guests.setPassword(password);
        ResultSet resultSet = dbManager.signIn(guests);

        int counter = 0;
        try {
            while (resultSet.next()) {
                counter++;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        if(counter >= 1) {
            System.out.println("Success");
        }
    }

}
