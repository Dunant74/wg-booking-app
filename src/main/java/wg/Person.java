package main.java.wg;

public class Person {
    private String name;

    public Person(String name){
        this.name = name;
    }

    public void sayHello(){
        System.out.println("Bonjour , je suis " + name);
    }

    public String getName(){
        return  name;
    }
}
