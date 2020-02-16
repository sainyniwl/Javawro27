package pl.sda.rafal.zientara.tdd.homework.farm.animals;

public class Dog extends MammalAnimal {

    public Dog(String skin, String name) {
        super(skin, name);
    }

    public Dog(String name) {
        super("fur", name);
    }

    public Dog() {
        this("Snoopy");
    }

    @Override
    String getSound() {
        return "Bark!";
    }
}
