package builders;

import interfaces.IChildBuilder;
import interfaces.IPersonBuilder;
import models.Person;

public class ChildBuilder implements IChildBuilder {
    private String name = "";
    private String surname = "";
    private int age = 0;
    private String address = "";

    public ChildBuilder(Person parent) {
        this.surname = parent.getSurname();
        this.address = parent.getAddress();
    }

    @Override
    public IChildBuilder setName(String name) {
        if(name.length()==0)
            throw new IllegalArgumentException("Указано пустое имя");
        this.name = name;
        return this;
    }

    @Override
    public IChildBuilder setAge(int age) {
        if(age<1)
            throw new IllegalArgumentException("Указан некорректный возраст");
        this.age = age;
        return this;
    }

    @Override
    public Person build() {
        if (this.name.length() == 0 || this.surname.length() == 0)
            throw new IllegalStateException("Невозможно создать объект Child без заполненого поля name");

        Person person = new Person(this.name, this.surname, this.age);
        return person;
    }
}
