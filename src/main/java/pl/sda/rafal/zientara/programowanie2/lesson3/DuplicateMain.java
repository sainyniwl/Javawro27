package pl.sda.rafal.zientara.programowanie2.lesson3;

import java.io.File;
import java.io.FileReader;

public class DuplicateMain {
    public static void main(String[] args) {
        String path1 = "podać ścieżkę do pliku";
        String path2 = "podać ścieżkę do pliku";

        File file1 = new File(path1);
        File file2 = new File (path2);
        boolean duplicate = FileMain.isDuplicate(file1,file2);
        System.out.println(duplicate);
    }
}
