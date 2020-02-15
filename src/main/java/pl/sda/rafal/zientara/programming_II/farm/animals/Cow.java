package pl.sda.rafal.zientara.programming_II.farm.animals;

public class Cow extends MammalAnimal {


    public Cow(String skin, String name) {
        super(skin, name);
    }

    public Cow(String name){
        this("futro", name);
    }

    public Cow(){
        this("Mućka");
    }
    @Override
    String getSound() {
        return "muuuuuu";
    }
}
