package pl.sda.rafal.zientara.tdd.File;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileMain {

    public static void main(String[] args) {
        File file = new File("/home/pawel/Javawro27/DATA");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println("exists:" + file.exists());
        System.out.println("parent:" + file.getParent());

        System.out.println("isDirectory:" + file.isDirectory());
        System.out.println("isFile:" + file.isFile());

        List<File> allFiles = new ArrayList<>();

        addSubFiles(file, allFiles);
    }

    private static void addSubFiles(File file, List<File> allFiles) {
        File[] files = file.listFiles();
        if (files != null) {
            System.out.println("=====FILES=====");
            for(File f : files) {
                System.out.println(f);
                if(f.isFile()) {
                    allFiles.add(f);
                }
            }
        } else {
            System.out.println("No subfiles for " + file.getName());
        }
    }
}
