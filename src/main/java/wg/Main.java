package main.java.wg;

import java.util.*;



public class Main {

        public static void main(String[] args) {

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
            }
        }

}
