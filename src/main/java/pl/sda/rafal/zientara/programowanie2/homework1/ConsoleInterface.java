package pl.sda.rafal.zientara.programowanie2.homework1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ConsoleInterface {

    Person person;
    int choice;
    List<Person> people = new ArrayList<>();

    public ConsoleInterface(){};

    public void mainMenu() {

        Scanner scanner0 = new Scanner(System.in);

        System.out.println("Witaj w systemie wprowadzania pracowników!");

        do {
            System.out.println("------------------------------");
            System.out.println("1. Dodaj użytkownika");
            System.out.println("2. Wyświetl użytkowników");
            System.out.println("3. Posortuj i exportuj listę pracowników");
            System.out.println("0. Wyjdż");
            choice = scanner0.nextInt();
            System.out.println("------------------------------");

            if (choice == 1) {
                person = new Person();
                Scanner scanner = new Scanner(System.in);
                System.out.println("Wprowadź imię: ");
                person.setName(scanner.next());
                System.out.println("Wprowadź nazwisko: ");
                person.setSurname(scanner.next());
                System.out.println("Wprowadź wiek: ");
                person.setAge(scanner0.nextInt());
                people.add(person);

            } else if (choice == 2) {
                for (Person element : people) {
                    System.out.println(element);
                }

            }else if(choice == 3){
                people.sort(new SortBySurname());
                try {
                    FileWriter writer = new FileWriter("JavaOut.csv");

                    for (Person element: people) {
                        writer.append(element.getData());
                        writer.append("\n");
                    }
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                }
        } while (choice != 0);
    }

}
