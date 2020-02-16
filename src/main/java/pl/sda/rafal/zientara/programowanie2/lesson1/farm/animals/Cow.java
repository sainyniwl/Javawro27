package pl.sda.rafal.zientara.programowanie2.lesson1.farm.animals;

import java.util.Random;

public class Cow extends MammalAnimal {

    public Cow(String skin, String name) {
        super(skin, name);
    }
    public Cow(String name) {
        super("futerko", name);
    }
    public Cow() {
        this("futerko", "Milka");
    }
    public int getMilk(){
        return new Random().nextInt(4);
    }

    @Override
    String getSound() {
        return "Muuuu";
    }
}
