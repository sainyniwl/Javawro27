package programowanie2.lesson1.homework.farm.animals;

public class Sparrow extends BirdAnimal {

    public Sparrow(String skin, String name) {
        super(skin, name);
    }

    public Sparrow(String name) {
        super("piora",name);
    }

    public Sparrow() {
        super("piora","Kapitan Jack");
    }

    @Override
    public boolean canFly() {
        return true;
    }

    @Override
    String getSound() {
        return "cwir cwir";
    }



}
