package pl.sda.rafal.zientara.programowanie2.lesson1.homework.farm;

import pl.sda.rafal.zientara.programowanie2.lesson1.homework.farm.animals.Cow;

public class MainCowFarm {

    public static void main(String[] args) {
        //todo 6. Stworz farme Donalda gdzie bedzie mozna wprowadzac tylko krowy i dodaj dowolna liczbe
        CowFarm cowFarms = new CowFarm();
        cowFarms.addAnimal(new Cow());
        cowFarms.addAnimal(new Cow());
        cowFarms.addAnimal(new Cow());
        cowFarms.addAnimal(new Cow());
        cowFarms.addAnimal(new Cow());
        cowFarms.addAnimal(new Cow());
        //todo 7. Wydrukuj zawartosc farmy przez printAllInfo()
        cowFarms.printAllInfo();
        System.out.println("Ile mleka: " + cowFarms.produceMilk());
    }
}
