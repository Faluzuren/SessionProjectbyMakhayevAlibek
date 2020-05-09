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
        } catch (Exception e) {
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

    public void signIn(String nickName, String password) {
        try{
            Statement statement = connection.createStatement();
            /*PreparedStatement statement =  connection.prepareStatement(
                    "SELECT * FROM users WHERE login = ? AND password = ?"
            );

             */
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM users WHERE login = ? AND password = ?"
            );
            if(resultSet.next()) {
                JOptionPane.showMessageDialog(null, "You were signed in");

            }else {
                JOptionPane.showMessageDialog(null, "An incorrect login or password");
            }
            } catch (Exception e) {
            e.printStackTrace();
        }
        }


    }
