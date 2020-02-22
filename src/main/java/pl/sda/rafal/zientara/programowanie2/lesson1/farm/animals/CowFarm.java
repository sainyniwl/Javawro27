package pl.sda.rafal.zientara.programowanie2.lesson1.farm.animals;

import pl.sda.rafal.zientara.programowanie2.lesson1.farm.OldMcDonaldFarm;


public class CowFarm <C extends Cow> extends OldMcDonaldFarm<C> {


    public int produceMilk(){
        int milk = 0;
        for (Cow cow : animals){
            milk += cow.getMilk();
        }
        return milk;
    }

}
