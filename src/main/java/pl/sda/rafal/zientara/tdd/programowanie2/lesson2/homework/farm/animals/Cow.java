package pl.sda.rafal.zientara.tdd.programowanie2.lesson2.homework.farm.animals;

public class Cow extends MammalAnimal {

    public Cow(String skin, String name) {
        super(skin, name);
    }



    @Override
    String getSound() {
        return "MOOOOOO";
    }

    @Override
    public String toString() {
        return "Krowa - "+super.toString();
    }
}
