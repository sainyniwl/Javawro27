package pl.sda.rafal.zientara.programowanie2.lesson2.homework;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Workers{
    List<Person> workers = new LinkedList<>();

    public void addWorkers (int numberOfWorkers){
        if(numberOfWorkers==0){
            System.out.println("Nie masz pracowników");
        } else {
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < numberOfWorkers; i++) {
                System.out.println("Podaj imię pracownika nr " + (i + 1) + ":");
                String name = scanner.next();
                System.out.println("Podaj nazwisko pracownikanr " + (i + 1) + ":");
                String lastName = scanner.next();
                System.out.println("Podaj wiek pracownikanr " + (i + 1) + ":");
                int age = scanner.nextInt();
                workers.add(new Person(name, lastName, age));
            }
            scanner.close();
            System.out.println(workers);
        }
    }


    public List<Person> sortWorkers(){
        return workers.stream()
                .sorted(new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o1.getLastName().compareTo(o2.getLastName());
                    }
                }).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Workers{" +
                "workers=" + workers +
                '}';
    }

    public static void main(String[] args) {
        Workers workers = new Workers();
        workers.addWorkers(2);
        System.out.println(workers.sortWorkers().toString());
    }
}
