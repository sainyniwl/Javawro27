package pl.sda.rafal.zientara.tdd.programowanie2.lesson1.homework.farm.animals;

public abstract class BirdAnimal extends Animal {

    public BirdAnimal(String skin, String name) {
        super(skin, name);
    }

    public String fly() {
        if(canFly()) {
            return " Lata";
        } else {
            return " Ptak nielot";
        }
    }

    public abstract boolean canFly();

    @Override
    public String toString() {
        return super.toString()+fly();
    }

}
