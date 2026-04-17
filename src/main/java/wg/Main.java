package main.java.wg;

public class Main {

        public static void main(String[] args) {
            User user1 = new User("Alice", "alice@example.com");

            user1.sayHello(); // méthode héritée
            user1.displayInfo();

            System.out.println();

            Room room1 = new Room("Cuisine", 4);
            room1.displayInfo();

            room1.setCapacity(6);
            System.out.println("New capacity: " + room1.getCapacity());
        }



}
