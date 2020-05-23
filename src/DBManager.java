import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    private Connection connection;
        public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/internerstore?useUnicode=true&serverTimezone=UTC", "root", ""
            );

            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate("INSERT INTO basket(customer_id, product_id, num, price)" + "VALUES (1, NULL, 50, 76000)");
            System.out.printf("Added %d rows", rows);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addGuests(Guests guests) {
        try {

            PreparedStatement statement = connection.prepareStatement("" + "INSERT INTO guests (id, nickname, password, email, region, status) " + "VALUES (NULL, ?, ?, ?, ?, ?)"
            );
            statement.setString(1, guests.getNickName());
            statement.setString(2, guests.getPassword());
            statement.setString(3, guests.getEmail());
            statement.setString(4, guests.getRegion());
            statement.setString(5, "offline");

            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successful registration");
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Guests> getAllGuests() {
        ArrayList<Guests> guestsArrayList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM guests");
            ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Integer id = resultSet.getInt("id");
                    String nickName = resultSet.getString("nickname");
                    String password = resultSet.getString("password");
                    String email = resultSet.getString("email");
                    String region = resultSet.getString("region");

                    guestsArrayList.add(new Guests(id, nickName, password, email, region, "offline"));


                }
            statement.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return guestsArrayList;
    }


    public ResultSet signIn(Guests guests) {
            ResultSet resultSet = null;
            try {
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM users WHERE nickname = ? AND password = ?"
                );
                statement.setString(1, guests.getNickName());
                statement.setString(2, guests.getPassword());

                resultSet = statement.executeQuery();

                if(resultSet.next()) {
                    JOptionPane.showMessageDialog(null, "Successful login");
                    Main.frame.AccessWindow.setVisible(false);
                    Main.frame.shopWindow.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username/password");
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }
            return resultSet;
    }

    public void addProduct(Products products) {
            try{
                PreparedStatement statement = connection.prepareStatement("" + "INSERT INTO basket (customer_id, product_id, num, price) " + "VALUES (?, NULL, ?, ?)"
                );
                statement.setInt(1, products.getCustomer_id());
                statement.setInt(2, products.getNum());
                statement.setInt(3, products.getPrice());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Successful registration");
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }

    }
