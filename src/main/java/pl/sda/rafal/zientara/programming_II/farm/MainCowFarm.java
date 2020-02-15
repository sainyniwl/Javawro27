package pl.sda.rafal.zientara.programming_II.farm;

import pl.sda.rafal.zientara.programming_II.farm.animals.Cow;
import pl.sda.rafal.zientara.programming_II.farm.animals.CowFarm;

public class MainCowFarm {

    public static void main(String[] args) {
        //todo 6. Stworz farme Donalda gdzie bedzie mozna wprowadzac tylko krowy i dodaj dowolna liczbe

        CowFarm<Cow> cowFarm = new CowFarm<>();

        cowFarm.addAnimal(new Cow());
        cowFarm.addAnimal(new Cow());
        cowFarm.addAnimal(new Cow());
        cowFarm.addAnimal(new Cow());
        cowFarm.addAnimal(new Cow());

        //todo 7. Wydrukuj zawartosc farmy przez printAllInfo()
        cowFarm.printAllInfo();
    }
}
