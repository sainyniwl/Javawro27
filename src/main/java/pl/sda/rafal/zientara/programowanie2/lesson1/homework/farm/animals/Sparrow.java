package pl.sda.rafal.zientara.programowanie2.lesson1.homework.farm.animals;

public class Sparrow extends BirdAnimal {

    public Sparrow(String skin, String name) {
        super(skin, name);
    }

    public Sparrow(String name) {
        this("piora", name);
    }

    public Sparrow() {
        this("piora", "Kapitan Jack");
    }

    @Override
    public boolean canFly() {
        return true;
    }

    @Override
    String getSound() {
        return "pi pi pi";
    }
}
