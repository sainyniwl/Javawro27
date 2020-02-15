package pl.sda.rafal.zientara.tdd.programowanie2.lesson2.homework.farm.animals;

public class Sparrow extends BirdAnimal {

    public Sparrow(String skin, String name) {
        super(skin, name);
    }

    @Override
    public boolean canFly() {
        return true;
    }

    @Override
    String getSound() {
        return "I AM A SPARROW, SPARROW";
    }

    @Override
    public String toString() {
        return "Papug - "+super.toString();
    }
}
