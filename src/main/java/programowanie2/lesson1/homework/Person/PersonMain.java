package homework.Person;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class PersonMain {
    public static void main(String[] args) throws FileNotFoundException {

        List<Person> persons = new ArrayList<>();

        Person person1 = new Person.PersonBuilder()
                .setName("Emcia")
                .setLastName("Wieczorek")
                .setAge(23)
                .create();

        Person person2 = new Person.PersonBuilder()
                .setName("Kondziu")
                .setLastName("Brylak")
                .setAge(27)
                .create();

        Person person3 = new Person.PersonBuilder()
                .setName("Zenek")
                .setLastName("Martyniuk")
                .setAge(3)
                .create();

        Person person4 = new Person.PersonBuilder()
                .setName("Imie4")
                .setLastName("Nazwisko4")
                .setAge(23)
                .create();

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);


        Person.handleSave(persons);


    }


}
