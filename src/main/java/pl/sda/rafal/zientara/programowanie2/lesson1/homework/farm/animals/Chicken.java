package pl.sda.rafal.zientara.programowanie2.lesson1.homework.farm.animals;

public class Chicken extends BirdAnimal {

    public Chicken(String skin, String name) {
        super(skin, name);
    }

    public Chicken() {
        this("scsac", "Cooww");
    }

    @Override
    public boolean canFly() {
        return false;
    }

    @Override
    String getSound() {
        return "Coco";
    }
}
