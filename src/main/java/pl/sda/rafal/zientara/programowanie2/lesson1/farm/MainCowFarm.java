package pl.sda.rafal.zientara.programowanie2.lesson1.farm;

import pl.sda.rafal.zientara.programowanie2.lesson1.farm.animals.Cow;
import pl.sda.rafal.zientara.programowanie2.lesson1.farm.animals.MammalAnimal;

public class MainCowFarm {

    public static void main(String[] args) {
        //todo 6. Stworz farme Donalda gdzie bedzie mozna wprowadzac tylko krowy i dodaj dowolna liczbe
        OldMcDonaldFarm<Cow> cowFarm = new OldMcDonaldFarm<>();
        cowFarm.addAnimal(new Cow("Milka1"));
        cowFarm.addAnimal(new Cow("Milka2"));
        cowFarm.addAnimal(new Cow("Milka3"));
        cowFarm.addAnimal(new Cow("Milka4"));
        cowFarm.addAnimal(new Cow("Milka5"));
        cowFarm.addAnimal(new Cow("Milka6"));

        //todo 7. Wydrukuj zawartosc farmy przez printAllInfo()
        cowFarm.printAllInfo();
    }
}
