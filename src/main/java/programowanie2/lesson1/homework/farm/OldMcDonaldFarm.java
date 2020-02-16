package programowanie2.lesson1.homework.farm;


import programowanie2.lesson1.homework.farm.animals.Animal;
import programowanie2.lesson1.homework.farm.animals.BirdAnimal;
import programowanie2.lesson1.homework.farm.animals.MammalAnimal;

import java.util.ArrayList;
import java.util.List;

public class OldMcDonaldFarm<T extends Animal> {
    private List<T> animals;

    public OldMcDonaldFarm() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(T newAnimal) {
        animals.add(newAnimal);
    }

    public T getAnimal(int i) {
        return animals.get(i);
    }

    public void printAllInfo() {
        System.out.println("Wszystkie zwierzeta");
        for (Animal temp : animals) {
            temp.printInfo();
        }
        System.out.println();
    }

    public void printBirdsInfo() {
        System.out.println("Ptaki na farmie:");
        // Wydrukuj informacje o zwierzakach do konsoli - ale tylko ptakach
        for(Animal x: animals)
            if (x instanceof BirdAnimal)
                System.out.println(x);

    }

    public void printMammalsInfo() {
        System.out.println("Ssaki na farmie:");
        // Wydrukuj informacje o zwierzakach do konsoli - ale tylko ssakach
        for(Animal x: animals)
            if (x instanceof MammalAnimal)
                System.out.println(x);
    }

}
