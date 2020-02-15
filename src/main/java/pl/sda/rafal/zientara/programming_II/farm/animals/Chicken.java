package pl.sda.rafal.zientara.programming_II.farm.animals;

public class Chicken extends BirdAnimal {


    public Chicken(String skin, String name) {
        super(skin, name);
    }

    public Chicken(String name){
        this("pióra", name);
    }

    public Chicken(){
        this("Kfc");
    }

    @Override
    public boolean canFly() {
        return false;
    }

    @Override
    String getSound() {
        return "kkokokoko";
    }


}
