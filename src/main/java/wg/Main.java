package wg;

import java.util.*;



public class Main {


        public static void main(String[] args) {
            /*
            try {
                Connection connection = DatabaseConnection.getConnection();
                System.out.println("Connexion PostgreSQL réussie !");
                connection.close();
            } catch (Exception e) {
                System.out.println("Erreur de connexion PostgreSQL");
                e.printStackTrace();
            }

            BookingManager manager = new BookingManager();

            manager.addUser(new User("Alice", "alice@example.com"));
            manager.addUser(new User("Bob", "bob@example.com"));
            manager.addUser(new User("Anna", "anna@example.com"));

            manager.addRoom(new Room("cuisine", 4));
            manager.addRoom(new Room("Salon", 2));
            manager.addRoom(new Room("Salle de réunino", 10));

            System.out.println("--- ALL Users----");
            manager.displayAllUsers();

            System.out.println("\n --- Users strating with A ----");
            manager.displayUsersStartingWith("A");

            System.out.println("\n ---- Rooms for 3 people ---");
            manager.displayAvailableRooms(3);

            System.out.println("\n---- Find User ----");

            try{
                User u = manager.findUser("alice@example.com");
                u.displayInfo();

                manager.findUser("unknown@email.com");
            }catch (UserNotFoundExecption e){
                System.out.println("Error: " + e.getMessage());
            }*/

            BookingManager manager = new BookingManager();

            System.out.println("--- USERS FROM DATABASE ---");

            List<User> usersFromDB = manager.getAllUsersFromDB();


            for (User u : usersFromDB) {
                u.displayInfo();
            }
        }

}
