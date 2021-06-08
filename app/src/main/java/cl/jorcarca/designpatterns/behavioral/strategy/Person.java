package cl.jorcarca.designpatterns.behavioral.strategy;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private int height;
    private String name;

    public Person(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public int getHeight() {
        return this.height;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Person o) {
        return Integer.valueOf(this.height).compareTo(Integer.valueOf(o.getHeight()));
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return height == person.height && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, name);
    }

}
