package programowanie2.lesson1.homework.farm.animals;

public class Cow extends MammalAnimal {
    public Cow(String skin, String name) {
        super(skin, name);
    }

    public Cow(String name) {
        super("futerko", name);
    }

    public Cow() {
        this("krowka");
    }

    @Override
    String getSound() {
        return "muuu";
    }
}
