package pl.sda.rafal.zientara.programowanie2.lesson1.farm;


import pl.sda.rafal.zientara.programowanie2.lesson1.farm.animals.*;

public class MainFarm {

    public static void main(String[] args) {
        OldMcDonaldFarm<Animal> donaldFarm = new OldMcDonaldFarm<>();
        //todo 5. Dodaj zwierzeta do zoo - po 1 z kazdego
        donaldFarm.addAnimal(new Cow("Milka"));
        donaldFarm.addAnimal(new Dog("Joko"));
        donaldFarm.addAnimal(new Chicken("KFC"));
        donaldFarm.addAnimal(new Sparrow("Kapitan Jack"));

        donaldFarm.printAllInfo();
        donaldFarm.printBirdsInfo();
        donaldFarm.printMammalsInfo();
    }
}
