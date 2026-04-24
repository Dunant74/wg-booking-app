package main.java.wg;

import java.util.Map;

public class User extends Person implements Displayable {
    String email;

    public User(String name, String email){
        super(name);
        this.email = email;

    }

    public String getEmail(){
        return  email;
    }

    @Override
    public void displayInfo(){
        System.out.println("User: " + getName() +  " | Email: " + email);
    }

}
