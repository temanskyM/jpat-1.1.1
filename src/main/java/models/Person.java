package models;

import builders.ChildBuilder;
import builders.PersonBuilder;
import interfaces.IChildBuilder;

public class Person {
    private final String name;
    private final String surname;
    private int age;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public IChildBuilder newChildBuilder(){
        IChildBuilder childBuilder = new ChildBuilder(this);
        return childBuilder;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getAge() {
        return age;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void happyBirthday() {
        this.age++;
    }

    public boolean hasAge() {
        if (this.age != 0){
            return true;
        }
        return false;
    }
    public boolean hasAddress(){
        if (this.address.length()>0)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

}
