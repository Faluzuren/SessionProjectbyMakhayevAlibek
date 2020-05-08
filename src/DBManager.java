import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

            PreparedStatement statement = connection.prepareStatement("" + "INSERT INTO guests (id, nickname, password, region) " + "VALUES (NULL, ?, ?, ?)"
            );
            statement.setString(1, guests.getNickName());
            statement.setString(2, guests.getPassword());
            statement.setString(3, guests.getRegion());

            statement.executeUpdate();

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
                String region = resultSet.getString("region");

                guestsArrayList.add(new Guests(id, nickName, password, region));
            }
            statement.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return guestsArrayList;
    }
}
