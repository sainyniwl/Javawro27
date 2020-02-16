package pl.sda.rafal.zientara.programowanie2.lesson1.farm.animals;

public class Dog extends MammalAnimal {

    public Dog(String skin, String name) {
        super(skin, name);
    }
    public Dog(String name) {
        super("sierść", name);
    }

    @Override
    String getSound() {
        return "Hau Hau";
    }
}
