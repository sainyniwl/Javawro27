package pl.sda.rafal.zientara.programming_II.farm;

import pl.sda.rafal.zientara.programming_II.farm.animals.*;

public class MainFarm {

    public static void main(String[] args) {
        OldMcDonaldFarm<Animal> donaldFarm = new OldMcDonaldFarm<>();
        //todo 5. Dodaj zwierzeta do zoo - po 1 z kazdego

        donaldFarm.addAnimal(new Cow());
        donaldFarm.addAnimal(new Chicken());
        donaldFarm.addAnimal(new Dog());
        donaldFarm.addAnimal(new Sparrow());


        donaldFarm.printAllInfo();
        donaldFarm.printBirdsInfo();
        donaldFarm.printMammalsInfo();
    }
}
