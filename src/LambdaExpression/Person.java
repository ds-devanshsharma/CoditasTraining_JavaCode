package LambdaExpression;

import java.util.ArrayList;
import java.util.List;

public class Person {
    enum Sex{MALE,FEMALE};
    String name;
    int age;
    String emailAddress;
    Sex gender;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", emailAddress='" + emailAddress + '\'' +
                ", gender=" + gender +
                '}';
    }

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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public Person(String name, int age, String emailAddress, Sex gender) {
        this.name = name;
        this.age = age;
        this.emailAddress = emailAddress;
        this.gender = gender;
    }

    public Person() {
    }
    public  void printPerson(){
        System.out.println(this.toString());
    }
    public static List<Person> generateDefaultList(){
        List<Person> people = new ArrayList<>();
        people.add(new Person("Devansh",21,"devansh@gamil.com",Sex.MALE));
        people.add(new Person("Shruti",20,"Shruti@gamil.com",Sex.FEMALE));
        people.add(new Person("Ashi",22,"Ashi@gamil.com",Sex.FEMALE));
        return people;
    }

}
