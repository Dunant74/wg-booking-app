package main.java.wg;

public class User {
    String name;
    String email;

    public User(String name, String email){
        this.name = name;
        this.email = email;

    }

    public void displayInfo(){
        System.out.println("User: " + name +  " | Email: " + email);
    }

    public void sayHello(){
        System.out.println("Bonjour, je suis  " + name + ".");
    }
}
