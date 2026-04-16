package main.java.wg;

public class Room {
    String name;
    int capacity;

    public Room(String name, int capacity){
        this.name  = name;
        this.capacity = capacity;
    }

    public void displayInfo() {
        System.out.println("Room:  " + name + " | Capacity: " + capacity);
    }

    public boolean canHost (int numberOfPeople){
        return  numberOfPeople <= capacity;
    }
}
