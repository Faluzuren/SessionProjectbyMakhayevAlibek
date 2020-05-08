import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUser extends Container {
    private JLabel PasswordLabel;
    private JLabel NickNameLabel;
    private JLabel RegionLabel;

    private JTextField NickNameText;
    private JTextField PasswordText;
    private String[] Regions = {"Asia", "Europe", "America",};
    private JComboBox RegionBox;

    private JButton regButton;
    private JButton backButton;

    public AddUser(){
        setSize(500,400);
        setLayout(null);

        NickNameLabel = new JLabel("Nickname");
        NickNameLabel.setBounds(90,60,60,30);
        add(NickNameLabel);

        NickNameText = new JTextField();
        NickNameText.setBounds(150, 60, 150, 30);
        add(NickNameText);

        PasswordLabel = new JLabel("Password");
        PasswordLabel.setBounds(90,100,60,30);
        add(PasswordLabel);

        PasswordText = new JTextField();
        PasswordText.setBounds(150, 100, 150,30);
        add(PasswordText);

        RegionLabel = new JLabel("Regions");
        RegionLabel.setBounds(90,140,60,30);
        add(RegionLabel);

        RegionBox = new JComboBox(Regions);
        RegionBox.setBounds(150,140,150,30);
        add(RegionBox);

        regButton = new JButton("REGISTRATION");
        regButton.setBounds(90, 220, 210, 30);
        regButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Password = PasswordText.getText();
                String Nickname = NickNameText.getText();
                String Regions = (String)RegionBox.getSelectedItem();

                Guests guests = new Guests(null, Nickname, Password, Regions);
                PackageData pd = new PackageData("REGISTRATION", guests);
                Main.connect(pd);

                NickNameText.setText("");
                PasswordText.setText("");

            }
        });
        add(regButton);

        backButton = new JButton("BACK");
        backButton.setBounds(90, 260, 210, 30);
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
