package homework.Person;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Person {
    private final String name;
    private final String lastName;
    private final int age;

    private Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.lastName = personBuilder.lastName;
        this.age = personBuilder.age;
    }

    @Override
    public String toString(){
        return name + " " + lastName + " " + age;
    }

    public String getData() {
        return name + ";" + lastName + ";" + age + ";";
    }


    static class PersonBuilder {
        private String name;
        private String lastName;
        private int age;


        PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }

        PersonBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        PersonBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        Person create(){
            return new Person(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }



    public static void handleSave(List<Person> list) throws FileNotFoundException {
        Optional<String> reduce = getData(list);
        if (reduce.isPresent()) {
            System.out.println(reduce.get());
            PrintWriter out = new PrintWriter("C:\\docsJava\\persons.csv");
            saveTextToFile(reduce.get(), out);
        }
    }

    private static Optional<String> getData(List<Person> list) {
        Scanner x = new Scanner(System.in);

        System.out.println("Po jakich danych przesortować osoby?");
        System.out.println("0-imię");
        System.out.println("1-nazwisko");
        System.out.println("2-wiek");

        int sortOption = x.nextInt();

        switch (sortOption){
            case 0:
                return list.stream()
                        .sorted((a,z) -> a.name.compareToIgnoreCase(z.name))
                        .map(Person::getData)
                        .reduce((acc, text) -> acc + "\n" + text);
            case 1:
                return list.stream()
                        .sorted((a,z) -> a.lastName.compareToIgnoreCase(z.lastName))
                        .map(Person::getData)
                        .reduce((acc, text) -> acc + "\n" + text);
            case 2:
                return list.stream()
                        .sorted(Comparator.comparingInt(a -> a.age))
                        .map(Person::getData)
                        .reduce((acc, text) -> acc + "\n" + text);
            default:
                return Optional.empty();
        }


    }

    private static void saveTextToFile(String content, PrintWriter file) {
        file.println(content);
        file.close();
    }



}



