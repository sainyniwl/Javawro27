package pl.sda.rafal.zientara.p2lesson1;

public class Main {
    public static void main(String[] args) { //singleton jest tylko jeden na cały program
        Singleton singleton = Singleton.getInstance(); //tworzy sie tylko raz i tylko wtedy gdy go tworzymy
        //new Singleton(); //konstruktor Singletonu powinien byc prywatny i juz nie pozwoli na utworzenie nowego
    }
}
