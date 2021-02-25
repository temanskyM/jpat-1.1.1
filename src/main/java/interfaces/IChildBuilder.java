package interfaces;

import models.Person;

public interface IChildBuilder {
    IChildBuilder setName(String name);
    IChildBuilder setAge(int age);
    Person build();
}
