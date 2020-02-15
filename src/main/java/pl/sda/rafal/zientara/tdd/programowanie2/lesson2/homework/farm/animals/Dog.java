package pl.sda.rafal.zientara.tdd.programowanie2.lesson2.homework.farm.animals;

public class Dog extends MammalAnimal {

    public Dog(String skin, String name) {
        super(skin, name);
    }

    @Override
    String getSound() {
        return "WOOOF";
    }

    @Override
    public String toString() {
        return "Dog:"+super.getName()+" makes:"+getSound()+" skin:"+getSkin();
    }
}
