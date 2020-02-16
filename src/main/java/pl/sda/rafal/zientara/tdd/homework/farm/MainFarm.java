package pl.sda.rafal.zientara.tdd.homework.farm;

import pl.sda.rafal.zientara.tdd.homework.farm.animals.Animal;

public class MainFarm {

    public static void main(String[] args) {
        OldMcDonaldFarm<Animal> donaldFarm = new OldMcDonaldFarm<>();
        //todo 5. Dodaj zwierzeta do zoo - po 1 z kazdego

        donaldFarm.printAllInfo();
        donaldFarm.printBirdsInfo();
        donaldFarm.printMammalsInfo();
    }
}
