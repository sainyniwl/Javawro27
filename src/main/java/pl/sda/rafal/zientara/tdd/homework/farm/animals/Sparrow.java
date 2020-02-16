package pl.sda.rafal.zientara.tdd.homework.farm.animals;

public class Sparrow extends BirdAnimal {

    public Sparrow(String skin, String name) {
        super(skin, name);
    }

    public Sparrow(String name) {
        super("pióra", name);
    }

    public Sparrow() {
        this("Captain Jack");
    }

    @Override
    public boolean canFly() {
        return true;
    }

    @Override
    String getSound() {
        return "Ćwir!";
    }
}
