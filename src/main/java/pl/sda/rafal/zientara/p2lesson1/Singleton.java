package pl.sda.rafal.zientara.p2lesson1;

public class Singleton {
    private static Singleton instance;
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
    private Singleton(){

    }

}
