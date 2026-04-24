package wg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class BookingManager {

    private Map<String, User> users = new HashMap<>();
    private List<Room> rooms  = new ArrayList<>();

    public void addUser(User user) {
        users.put(user.getEmail(), user);
    }

    public void  addRoom (Room room){
        rooms.add(room);
    }

    public User findUser(String email) throws UserNotFoundExecption{

        if(!users.containsKey(email)){
            throw new UserNotFoundExecption( "User not found: " + email);
        }

        return users.get(email);
    }

    public void displayAllUsers(){
        users.values().forEach(u -> u.displayInfo());
    }

    public void displayUsersStartingWith(String letter){
        users.values().stream()
                .filter(u -> u.getName().startsWith(letter))
                .forEach(u -> u.displayInfo());
    }

    public void displayAvailableRooms (int people){
        rooms.stream()
                .filter(r -> r.canHost(people))
                .forEach( r-> r.displayInfo());
    }

    public List<User> getAllUsersFromDB() {
        List<User> users = new ArrayList<>();

        String query = "SELECT name, email FROM users";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");

                User user = new User(name, email);
                users.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    public void addUserToDB(User user) {
        String query = "INSERT INTO users (name, email) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());

            pstmt.executeUpdate();

            System.out.println("User ajouté en DB !");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUserEmail(String oldEmail, String newEmail) {
        String sql = "UPDATE users SET email = ? WHERE email = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newEmail);
            pstmt.setString(2, oldEmail);

            int rowsUpdated = pstmt.executeUpdate();

            System.out.println(rowsUpdated + " user updated.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUserByEmail(String email) {
        String sql = "DELETE FROM users WHERE email = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);

            int rowsDeleted = pstmt.executeUpdate();

            System.out.println(rowsDeleted + " user deleted.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
