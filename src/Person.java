import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Person p1 = new Person("A", 12);
        Person p2 = new Person("B", 10);
        Person p3 = new Person("C", 9);
        Person p4 = new Person("D", 1);
        Person p5 = new Person("E", 15);

        List<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        persons.add(p5);



    }
}
