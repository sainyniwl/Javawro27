package pl.sda.rafal.zientara.programowanie2.lesson1.homework.farm;

import pl.sda.rafal.zientara.programowanie2.lesson1.homework.farm.animals.Animal;

public class MainFarm {

    public static void main(String[] args) {
        OldMcDonaldFarm<Animal> donaldFarm = new OldMcDonaldFarm<>();
        //todo 5. Dodaj zwierzeta do zoo - po 1 z kazdego

        donaldFarm.printAllInfo();
        donaldFarm.printBirdsInfo();
        donaldFarm.printMammalsInfo();
    }
}
