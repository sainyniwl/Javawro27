package pl.sda.rafal.zientara.programowanie2.lesson3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileMain {

    public static void main(String[] args) {
        File file = new File("C:\\DATA\\");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println("exists:" + file.exists());
        System.out.println("parent:" + file.getParent());

        System.out.println("isDirectory:" + file.isDirectory());
        System.out.println("isFile:" + file.isFile());


        List<File> allFiles = new ArrayList<>();

        addSubFiles(file, allFiles);

//        printFilteredFiles(allFiles);
        System.out.println("===================== FINAL RESULT =====================");
        for (File f : allFiles) {
            System.out.println(f);
        }
//        List<File> pngFiles = allFiles.stream()
//                .filter(fil -> fil.getName().endsWith(".png"))
//                .collect(Collectors.toList());

        killDuplicates(allFiles);
    }

    private static void killDuplicates(List<File> allFiles) {
        for (File png : allFiles) {
            System.out.println("Checking duplicates for " + png);
            List<File> duplicates = getDuplicates(png, allFiles);
            System.out.println("Duplicates:" + duplicates);
//            deleteDuplicates(duplicates);
        }
    }

    private static void deleteDuplicates(List<File> duplicates) {
        for (File dup : duplicates) {
            long size = dup.length();
            boolean delete = dup.delete();
            if (delete) {
                System.out.println("zwolniono " + size);
            } else {
                System.out.println("Nie udalo sie usunac");
            }
        }
    }

    private static List<File> getDuplicates(File png, List<File> pngFiles) {
        List<File> duplicates = new ArrayList<>();
        for (File possibleDuplicate : pngFiles) {
            if (isDuplicate(png, possibleDuplicate)) {
                duplicates.add(possibleDuplicate);
            }
        }
        return duplicates;
    }

    public static boolean isDuplicate(File png, File possibleDuplicate) {
        //C:\DATA\data-wyszukiwanie plikow\subfolder3-editpng\inna nazwa xD.png
        //C:\DATA\data-wyszukiwanie plikow\subfolder3-editpng\inna nazwa xD.png
        //to jestem ja!
        if (png.getAbsolutePath().equals(possibleDuplicate.getAbsolutePath())) {
            return false;
        }
        //te same rozmiary pliku
        if (png.length() == possibleDuplicate.length()) {
            //todo porownaj pliki bajt po bajcie
            return true;
        } else {
            return false;
        }
    }

    private static boolean compareByBytes(File png, File possibleDuplicate) {
        try {
            FileReader reader1 = new FileReader(png);
            FileReader reader2 = new FileReader(possibleDuplicate);

            int read1;
            int read2;
            do {
                read1 = reader1.read();
                read2 = reader2.read();
                if (read1 != read2) {
                    System.out.println("Inne " + read1 + " !=  " + read2);
                    reader1.close();
                    reader2.close();
                    return false;
                }
            } while (read1 != -1 && read2 != 1);
            reader1.close();
            reader2.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Nie ma takiego pliku");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Błąd odczytu");
            e.printStackTrace();
        }
       return false;
    }

    private static void printFilteredFiles(List<File> allFiles) {
        System.out.println("===================== FINAL RESULT =====================");
        for (File f : allFiles.stream()
                .filter(fil -> fil.getName().endsWith(".png"))
                .collect(Collectors.toList())) {
            System.out.println(f);
        }
    }

    private static void addSubFiles(File file, List<File> allFiles) {
        File[] files = file.listFiles();
        if (files != null) {
            System.out.println("============SUB_FILES============");
            for (File subFile : files) {
                System.out.println(subFile);
                if (subFile.isFile()) {
                    allFiles.add(subFile);
                } else if (subFile.isDirectory()) {
                    addSubFiles(subFile, allFiles);
                }
            }
        } else {
            System.out.println("No sub files for " + file.getName());
        }
    }
}