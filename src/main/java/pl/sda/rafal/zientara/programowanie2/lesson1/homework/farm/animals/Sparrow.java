package pl.sda.rafal.zientara.programowanie2.lesson1.homework.farm.animals;

public class Sparrow extends BirdAnimal {
    public Sparrow(String skin, String name) {
        super(skin, name);
    }

    public Sparrow(String name) {
        super("piórka",  name);
    }

    public Sparrow() {
        this("Elemelek");
    }

    @Override
    public boolean canFly() {
        return true;
    }

    @Override
    String getSound() {
        return "Cwir cwir";
    }
}
