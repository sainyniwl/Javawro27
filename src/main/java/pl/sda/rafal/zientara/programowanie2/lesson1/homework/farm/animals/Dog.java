package pl.sda.rafal.zientara.programowanie2.lesson1.homework.farm.animals;

public class Dog extends MammalAnimal {

    public Dog(String skin, String name) {
        super(skin, name);
    }

    public Dog(String name) {
        super("futerko",  name);
    }

    public Dog() {
        this("Burek");
    }

    @Override
    String getSound() {
        return "Hau Hau";
    }
}
