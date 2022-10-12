import java.lang.*;

public class Person {
    String birthDay;
    String age;
    String name;

    public Person(String birthDay, String age, String name) {
        this.birthDay = birthDay;
        this.age = age;
        this.name = name;
    }

    public String getBirthDay() { return birthDay; }
    public String getAge() { return age; }
    public String getName() { return name; }

    public void print() {
        System.out.println("Birth Day : " + getBirthDay());
        System.out.println("Age : " + getAge());
        System.out.println("Name : " + getName());
    }

    public static void main(String[] args) {
        Person person = new Person("19991129", "22", "ParkJeeon");
        person.print();
    }

}
