package programowanie2.lesson1.homework.farm.animals;

public class Dog extends MammalAnimal {
    public Dog(String skin, String name) {
        super(skin, name);
    }

    public Dog(String name) {
        super("fur", name);
    }

    public Dog() {
        super("fur","burek");
    }

    @Override
    String getSound() {
        return "halhalhal";
    }
}
