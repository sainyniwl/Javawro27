package pl.sda.rafal.zientara.programowanie2.lesson1.homework.farm.animals;

public class Sparrow extends BirdAnimal {
    public Sparrow(String skin, String name) {
        super(skin, name);
    }


    public Sparrow(String name) {
        super("kolorowe piórka", name);
    }
    public Sparrow() {
        this("Ara");
    }

    @Override
    public boolean canFly() {
        return true;
    }

    @Override
    String getSound() {
        return "spar spar";
    }
}
