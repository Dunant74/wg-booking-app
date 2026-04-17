package main.java.wg;

public class User extends Person {
    String email;

    public User(String name, String email){
        super(name);
        this.email = email;

    }

    public String getEmail(){
        return  email;
    }
    public void displayInfo(){
        System.out.println("User: " + getName() +  " | Email: " + email);
    }

}
