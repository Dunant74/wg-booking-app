package wg;

import java.sql.Connection;
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

}
