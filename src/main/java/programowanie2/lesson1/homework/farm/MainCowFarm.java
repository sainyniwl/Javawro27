package programowanie2.lesson1.homework.farm;

import programowanie2.lesson1.homework.farm.animals.Cow;

public class MainCowFarm {

    public static void main(String[] args) {
        // Stworz farme Donalda gdzie bedzie mozna wprowadzac tylko krowy i dodaj dowolna liczbe
        // Wydrukuj zawartosc farmy przez printAllInfo()

        OldMcDonaldFarm<Cow> cowFarm = new OldMcDonaldFarm<>();

        cowFarm.addAnimal(new Cow());
        cowFarm.addAnimal(new Cow());
        cowFarm.addAnimal(new Cow());

        cowFarm.printAllInfo();

    }
}
