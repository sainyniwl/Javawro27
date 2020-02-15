package pl.sda.rafal.zientara.programming_II.farm.animals;

public class Dog extends MammalAnimal {


    public Dog(String skin, String name) {
        super(skin, name);
    }

    public Dog(String name){
        super("sierść", name);
    }

    public Dog(){
        this("sierść", "Azor");
    }

    @Override
    String getSound() {
        return "hau hau";
    }


}
