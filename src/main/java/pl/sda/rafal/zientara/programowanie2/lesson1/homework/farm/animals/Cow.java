package pl.sda.rafal.zientara.programowanie2.lesson1.homework.farm.animals;

import java.util.Random;

public class Cow extends MammalAnimal {

    public Cow(String skin, String name) {
        super("futerko", name);
    }

    public Cow() {
        this("futerko", "Coww");
    }

    @Override
    String getSound() {
        return "Moooo";
    }

    public int getMilk() {
        return new Random().nextInt(4);
    }


}
