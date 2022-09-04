package LambdaExpression;

import java.util.List;
import java.util.Objects;

/**
 * java 8 -> lambdaExpression
 */
//functional interface
interface Test{
    boolean check(Person p);
}
public class LambdaExpressionDemo {
     static List<Person> personList = Person.generateDefaultList();
     void filterBasedOnLengthOfName(){
         for(Person person : personList){
                 if(((Test) p -> {
                     if (p.getName().length() > 4) return true;
                     return false;
                 }).check(person))person.printPerson();
         }
     }
    public static void main(String[] args) {
         // normal list
        System.out.println("NORMAL LIST ");
         personList.stream()
                 .forEach(System.out::println);
//        // PRINT AGE BY INCREASING 10
//        System.out.println("AFTER LIST ");
//        personList.stream().
//                map(person ->new Person(
//                        person.getName(),person.getAge()+10,
//                        person.getEmailAddress(),person.getGender()
//                )).forEach(System.out::println);
//        System.out.println("FEMALE ONLY ");
//        personList.stream()
//                        .filter(person -> person.gender== Person.Sex.FEMALE)
//                .forEach(System.out::println);
        //update person whose age is 22
    }

}
