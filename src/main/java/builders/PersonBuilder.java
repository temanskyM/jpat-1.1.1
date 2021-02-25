package builders;

import interfaces.IPersonBuilder;
import models.Person;

public class PersonBuilder implements IPersonBuilder {
    private String name = "";
    private String surname = "";
    private int age = 0;
    private String address = "";

    public PersonBuilder() {
    }

    @Override
    public PersonBuilder setName(String name) {
        if (name.length() == 0)
            throw new IllegalArgumentException("Указано некорректное имя");
        this.name = name;
        return this;
    }

    @Override
    public IPersonBuilder setSurname(String surname) {
        if (surname.length() == 0)
            throw new IllegalArgumentException("Указана пустая фамилия");
        this.surname = surname;
        return this;
    }

    @Override
    public IPersonBuilder setAge(int age) {
        if (age < 1)
            throw new IllegalArgumentException("Указан некорректный возраст");
        this.age = age;
        return this;
    }

    @Override
    public IPersonBuilder setAddress(String address) {
        if (address.length() == 0)
            throw new IllegalArgumentException("Указан пустой адрес");
        this.address = address;
        return this;
    }

    @Override
    public Person build() {
        if (this.name.length() == 0 || this.surname.length() == 0)
            throw new IllegalStateException("Невозможно создать объект Person без заполненых полей name и surname");

        Person person = new Person(this.name, this.surname, this.age);
        person.setAddress(this.address);
        return person;
    }
}
