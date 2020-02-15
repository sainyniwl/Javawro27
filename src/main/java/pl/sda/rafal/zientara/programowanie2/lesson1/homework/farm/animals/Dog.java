package pl.sda.rafal.zientara.programowanie2.lesson1.homework.farm.animals;

public class Dog extends MammalAnimal {

    public Dog(String skin, String name) {
        super("skin", name);
    }

    public Dog() {
        this("wlosy", "super Dog");
    }

    @Override
    String getSound() {
        return "Woof";
    }
}
