package pl.sda.rafal.zientara.programowanie2.lesson2.homework;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Workers workers=new Workers();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ilu masz pracowników w firmie?");
        int workersNumber = scanner.nextInt();
        workers.addWorkers(workersNumber);
        System.out.println(workers);
    }
}
