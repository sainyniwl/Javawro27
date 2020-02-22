package pl.sda.rafal.zientara.programowanie2.lesson1.homework.farm.animals;

public class Dog extends MammalAnimal {
    public Dog(String skin, String name) {
        super(skin, name);
    }


    public Dog(String name) {
        super("futerko", name);
    }
    public Dog() {
        this("Pluto");
    }

    @Override
    String getSound() {
        return "hau hau";
    }
}
