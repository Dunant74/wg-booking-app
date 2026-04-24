package main.java.wg;

public class Room implements Displayable {
    private String name;
    private int capacity;

    public Room(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
        }
    }

    public boolean canHost(int numberOfPeople) {
        return numberOfPeople <= capacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Room: " + name + " | Capacity: " + capacity);
    }
}
