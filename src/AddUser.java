import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUser extends Container {
    private JLabel PasswordLabel;
    private JLabel NickNameLabel;
    private JLabel emailLabel;
    private JLabel RegionLabel;

    private JTextField NickNameText;
    private JPasswordField PasswordText;
    private JTextField emailText;
    private String[] Regions = {"Asia", "Europe", "America",};
    private JComboBox RegionBox;

    private JButton regButton;
    private JButton backButton;

    public AddUser(){
        setSize(1200,1000);
        setLayout(null);

        NickNameLabel = new JLabel("Nickname");
        NickNameLabel.setBounds(400,300,60,30);
        add(NickNameLabel);

        NickNameText = new JTextField();
        NickNameText.setBounds(460, 300, 150, 30);
        add(NickNameText);

        PasswordLabel = new JLabel("Password");
        PasswordLabel.setBounds(400,340,60,30);
        add(PasswordLabel);

        PasswordText = new JPasswordField();
        PasswordText.setBounds(460, 340, 150,30);
        add(PasswordText);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(400,380,60,30);
        add(emailLabel);

        emailText = new JTextField();
        emailText.setBounds(460, 380, 150, 30);
        add(emailText);

        RegionLabel = new JLabel("Regions");
        RegionLabel.setBounds(400,420,60,30);
        add(RegionLabel);

        RegionBox = new JComboBox(Regions);
        RegionBox.setBounds(460,420,150,30);
        add(RegionBox);

        regButton = new JButton("REGISTRATION");
        regButton.setBounds(400, 500, 210, 30);
        regButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Nickname = NickNameText.getText().trim();
                String Password = PasswordText.getText().trim();
                String email = emailText.getText();
                String Regions = (String)RegionBox.getSelectedItem();

                Guests guests = new Guests(null, Nickname, Password, email, Regions, "offline");
                PackageData pd = new PackageData("REGISTRATION", guests);
                Main.connect(pd);

                NickNameText.setText("");
                PasswordText.setText("");
                emailText.setText("");

            }
        });
        add(regButton);

        backButton = new JButton("BACK");
        backButton.setBounds(400, 600, 210, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.menuWindow.setVisible(true);
                Main.frame.AddWindow.setVisible(false);
            }
        });
        add(backButton);
    }
}
