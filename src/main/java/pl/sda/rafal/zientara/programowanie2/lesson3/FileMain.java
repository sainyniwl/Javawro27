package pl.sda.rafal.zientara.programowanie2.lesson3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileMain {

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

    private static void killDuplicates(List<File> allFiles) {
        for (File png : allFiles) {
            System.out.println("Checking duplicates for " + png);
            List<File> duplicates = getDuplicates(png, allFiles);
            System.out.println("Duplicates:" + duplicates);
//            for(File dup : duplicates){
//                allFiles.remove(dup);
//            }
            deleteDuplicates(duplicates);
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

    private static boolean isDuplicate(File png, File possibleDuplicate) {
        //C:\DATA\data-wyszukiwanie plikow\subfolder3-editpng\inna nazwa xD.png
        //C:\DATA\data-wyszukiwanie plikow\subfolder3-editpng\inna nazwa xD.png
        //to jestem ja!
        if (png.getAbsolutePath().equals(possibleDuplicate.getAbsolutePath())) {
            return false;
        }
        //te same rozmiary pliku
        if (png.length() == possibleDuplicate.length()) {
//            compareByByte(png, possibleDuplicate);
            return true;
        } else {
            return false;
        }
    }

    private static void printFilteredFiles(List<File> allFiles) {
        System.out.println("=============FINAL_RESULT_FILTERED_FILES==============");
        for (File f : allFiles.stream()
                .filter(file1 -> file1.getName()
                        .endsWith(".png"))
                .collect(Collectors.toList())) {
            System.out.println(f);
        }
    }

    private static void addSubFiles(File file, List<File> allFiles) {
        File[] files = file.listFiles();
        if (files != null) {
            System.out.println("===========SUB_FILES============");
            for (File subFiles : files) {
                System.out.println(subFiles);
                if (subFiles.isFile()) {
                    allFiles.add(subFiles);
                } else if (subFiles.isDirectory()) {
                    addSubFiles(subFiles, allFiles);
                }
            }
        } else {
            System.out.println("No sub files for: " + file.getName());
        }
    }

    private static boolean compareByByte(File png, File possibleDuplicate) {
        try {
            FileReader reader1 = new FileReader(png);
            FileReader reader2 = new FileReader(possibleDuplicate);

            char[] buffer1 = new char[1024];
            char[] buffer2 = new char[1024];
            int read1;
            int read2;

            do {
                read1 = reader1.read(buffer1);
                read2 = reader2.read(buffer2);
                if (read1 != read2) {
                    System.out.println("Inne! " + read1 + " != " + read2);
                    reader1.close();
                    reader2.close();
                    return false;
                } else {
                    for (int i = 0; i < buffer1.length; i++) {
                        char c1 = buffer1[i];
                        char c2 = buffer2[i];
                        if (c1 == c2) {
                            System.out.println("Inne! " + read1 + " != " + read2);
                            reader1.close();
                            reader2.close();
                            return false;
                        }
                    }
                }
            } while (read1 != -1 && read2 != -1);

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

    public static void main(String[] args) {
        File file = new File("/Users/maciekn/Documents/DATA");
        System.out.println(file.getAbsolutePath());
        System.out.println("Exists: " + file.exists());
        System.out.println("Get Parent: " + file.getParent());
        System.out.println(file.isDirectory());

        List<File> allFiles = new ArrayList<>();

        addSubFiles(file, allFiles);
//        printFilteredFiles(allFiles);

//        System.out.println("=============FINAL_RESULT==============");
//        List<File> pngFiles = allFiles.stream()
//                .filter(file1 -> file1.getName()
//                        .endsWith(".png"))
//                .collect(Collectors.toList());
//
//        for (File png: pngFiles) {
//            System.out.println("Checking duplicates for: " + png);
//            List<File> duplicates = getDuplicates(png, pngFiles);
//            System.out.println("Duplicates: " + duplicates);
//            deleteDuplicates(duplicates);
//        }

        System.out.println("===================== FINAL RESULT =====================");
        for (File f : allFiles) {
            System.out.println(f);
        }
//        List<File> pngFiles = allFiles.stream()
//                .filter(fil -> fil.getName().endsWith(".png"))
//                .collect(Collectors.toList());

        killDuplicates(allFiles);

    }


}

