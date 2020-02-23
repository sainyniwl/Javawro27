package pl.sda.rafal.zientara.tdd.file;

import java.io.File;

public class DuplicateMain {

    public static void main(String[] args) {

        String path1 = "/home/pawel/Javawro27/tekst.txt";
        String path2 = "/home/pawel/Javawro27/tekst2.txt";

        File file1 = new File(path1);
        File file2 = new File(path2);

        boolean duplicate = FileMain.isDuplicate(file1, file2);

        System.out.println(duplicate);
    }
}
