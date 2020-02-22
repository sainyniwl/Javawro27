package pl.sda.rafal.zientara.tdd.File;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileMain {

    public static void main(String[] args) {
        File file = new File("/home/pawel/Javawro27/DATA");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println("exists: " + file.exists());
        System.out.println("parent: " + file.getParent());

        System.out.println("isDirectory: " + file.isDirectory());
        System.out.println("isFile: " + file.isFile());

        List<File> allFiles = new ArrayList<>();

        addSubFiles(file, allFiles);

        //printFilteredFiles(allFiles);
        System.out.println("===================== FINAL RESULT =====================");
        for (File f : allFiles) {
            System.out.println(f);
        }
        //List<File> pngFiles = allFiles.stream()
//                .filter(fil -> fil.getName().endsWith(".png"))
//                .collect(Collectors.toList());

        killDuplicates(allFiles);
    }

    private static void killDuplicates(List<File> allFiles) {
        for (File png : allFiles) {
            System.out.println("Checking duplicates for " + png);
            List<File> duplicates = getDuplicates(png, allFiles);
            System.out.println("Duplicates:" + duplicates);
            deleteDuplicates(duplicates);
        }
    }

    private static void deleteDuplicates(List<File> duplicates) {
        for(File dup : duplicates) {
            long size = dup.length();
            boolean delete = dup.delete();
            if (delete) {
                System.out.println("Zwolniono: " + size);
            } else {
                System.out.println("Nie udało się usunąć");
            }
        }
    }

    private static List<File> getDuplicates(File png, List<File> pngFiles) {
        List<File> duplicates = new ArrayList<>();
        for (File possibleDuplicate : pngFiles) {
            if(isDuplicate(png, possibleDuplicate)) {
                duplicates.add(possibleDuplicate);
            }
        }
        return duplicates;
    }

    private static boolean isDuplicate(File png, File possibleDuplicate) {
        if (png.getAbsolutePath().equals(possibleDuplicate.getAbsolutePath())) {
            return false;
        }

        if (png.length() == possibleDuplicate.length()) {
            //TODO porównaj pliki bajt po bajcie
            return true;
        } else {
            return false;
        }
    }

    private static void printFilteredFiles(List<File> allFiles) {
        System.out.println("===== FINAL RESULT =====");
        for(File f : allFiles.stream()
        .filter(fil -> fil.getName().endsWith(".png"))
        .collect(Collectors.toList())) {
            System.out.println(f);
        }
    }

    private static void addSubFiles(File file, List<File> allFiles) {
        File[] files = file.listFiles();
        if (files != null) {
            //System.out.println("===== FILES =====");
            for(File subFile : files) {
                //System.out.println(subFile);
                if(subFile.isFile()) {
                    allFiles.add(subFile);
                } else if (subFile.isDirectory()) {
                    addSubFiles(subFile, allFiles);
                }
            }
        } else {
            System.out.println("No subfiles for " + file.getName());
        }
    }
}
