import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShopWindow extends Container {
    private JButton firstbutton;
    private JButton addfirst;
    private JButton secondbutton;
    private JButton addsecond;
    private JButton thirdbutton;
    private JButton addthird;
    private JButton backButton;
    public ShopWindow() {
        setSize(1200,1000);
        setLayout(null);

        firstbutton = new JButton();
        firstbutton.setBounds(30, 60, 200, 200);
        firstbutton.setIcon(new ImageIcon("src/img/globe-bantam-st-1.jpg"));
        firstbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Text here", "Globe Bantam", 1);
            }
        });

        add(firstbutton);

        addfirst = new JButton("ADD");
        addfirst.setBounds(30, 300, 200, 30);
        addfirst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Products products = new Products(1, null,50, 10000);
                ProductData pd1 = new ProductData("ADDPROD", products);
            }
        });

        add(addfirst);

        secondbutton = new JButton();
        secondbutton.setBounds(290, 60, 200, 200);
        secondbutton.setIcon(new ImageIcon("src/img/Hudora_Longboard.jpg"));
        secondbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Text here", "Hundora LongBoard", 1);
            }
        });

        add(secondbutton);

        addsecond = new JButton("ADD");
        addsecond.setBounds(290, 300, 200, 30);

        add(addsecond);

        thirdbutton = new JButton();
        thirdbutton.setBounds(550, 60, 200, 200);
        thirdbutton.setIcon(new ImageIcon("src/img/Penny JP-HB-12.jpg"));
        thirdbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Text here", "Penny JP-HB-12", 1);
            }
        });

        add(thirdbutton);

        addthird = new JButton("ADD");
        addthird.setBounds(550, 300, 200, 30);

        add(addthird);

        backButton = new JButton("BACK");
        backButton.setBounds(450, 750, 210, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.menuWindow.setVisible(true);
                Main.frame.shopWindow.setVisible(false);
            }
        });
        add(backButton);
    }


}
