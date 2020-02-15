package pl.sda.rafal.zientara.tdd.programowanie2.lesson2.homework.farm.animals;

public class Chicken extends BirdAnimal {

    public Chicken(String skin, String name) {
        super(skin, name);
    }

    @Override
    public boolean canFly() {
        return false;
    }

    @Override
    String getSound() {
        return "BUCK BUCK";
    }

    @Override
    public String toString() {
        return "Kujczak - "+super.toString();
    }
}
