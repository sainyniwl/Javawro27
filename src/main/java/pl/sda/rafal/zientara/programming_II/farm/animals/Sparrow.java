package pl.sda.rafal.zientara.programming_II.farm.animals;

public class Sparrow extends BirdAnimal {


    public Sparrow(String skin, String name) {
        super(skin, name);
    }

    public Sparrow(String name){
        this("pióra", name);
    }
    public Sparrow(){
        this("Kapitan Jack");
    }

    @Override
    public boolean canFly() {
        return true;
    }

    @Override
    String getSound() {
        return "ćwir ćwir";
    }


}
