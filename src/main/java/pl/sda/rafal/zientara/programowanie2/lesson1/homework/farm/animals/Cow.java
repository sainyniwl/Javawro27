package pl.sda.rafal.zientara.programowanie2.lesson1.homework.farm.animals;

import java.util.Random;

public class Cow extends MammalAnimal {
    public Cow(String skin, String name) {
        super(skin, name);
    }

    public Cow(String name) {
        super("łaciata skórka", name);
    }
    public Cow() {
        this( "Milka");
    }

    @Override
    String getSound() {
        return "muu";
    }

    public int getMilk(){
        return new Random().nextInt(4);
    }
}
