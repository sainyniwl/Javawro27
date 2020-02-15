package pl.sda.rafal.zientara.programowanie2.lesson1.homework.farm;

import pl.sda.rafal.zientara.programowanie2.lesson1.homework.farm.animals.Cow;
import pl.sda.rafal.zientara.programowanie2.lesson1.homework.farm.animals.Dog;
import pl.sda.rafal.zientara.programowanie2.lesson1.homework.farm.animals.MammalAnimal;

public class MainCowFarm {

    public static void main(String[] args) {
        //todo 6. Stworz farme Donalda gdzie bedzie mozna wprowadzac tylko krowy i dodaj dowolna liczbe
        OldMcDonaldFarm<MammalAnimal> mammalFarm = new OldMcDonaldFarm<>();
        mammalFarm.addAnimal(new Dog());
        mammalFarm.addAnimal(new Cow());

        //todo 7. Wydrukuj zawartosc farmy przez printAllInfo()

        mammalFarm.printAllInfo();
    }
}
