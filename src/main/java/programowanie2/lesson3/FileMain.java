package programowanie2.lesson3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileMain {
    public static void main(String[] args) {
        File file = new File("C:\\DATA\\data-wyszukiwanie plikow");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println("Exist: " + file.exists());
        System.out.println("Parent: " + file.getParent());

        System.out.println("Is directory: " + file.isDirectory());


        List<File> allFiles = new ArrayList<>();


        addSubFiles(file, allFiles);
        System.out.println("===================FINAL RESULT===================");
//        printFilteredFiles(allFiles);

        List<File> pngFiles = allFiles.stream().filter(fil -> fil.getName().endsWith(".png")).collect(Collectors.toList());

        for (File png: pngFiles){
            System.out.println("Checking duplicates for " + png);
            List<File> duplicates = getDuplicates(png, pngFiles);
            System.out.println("Duplicates: " + duplicates);
            deleteDuplicates(duplicates);
        }
    }

    private static void deleteDuplicates(List<File> duplicates) {
        for (File f: duplicates) {
            boolean delete = f.delete();
            long size = f.length();
            if (delete){
                System.out.println("Zwolniono " + size);
            } else {
                System.out.println("Nie udalo sie usunac!");
            }
        }
    }

    private static List<File> getDuplicates(File png, List<File> pngFiles) {
        List<File> duplicates = new ArrayList<>();
        for (File possibleDuplicate : pngFiles){
            if(isDuplicate(png, possibleDuplicate)){
                duplicates.add(possibleDuplicate);
            }
        }
        return duplicates;
    }

    private static boolean isDuplicate(File png, File possibleDuplicate) {
        if (png.getAbsolutePath() == possibleDuplicate.getAbsolutePath()){
            return false;
        }
        if (png.length() == possibleDuplicate.length()){
            //todo - Porownaj pliki byte po bytcie
            return compareByBytes(png, possibleDuplicate);
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
            do{
               read1 = reader1.read();
               read2 = reader2.read();
                if (read1 != read2){
                    System.out.println("Inne!" + read1 + "!=" + read2);
                    reader1.close();
                    reader2.close();
                    return false;
                }
            } while (read1 !=-1 && read2 != -1);

            reader1.close();
            reader2.close();
            return true;
        } catch (FileNotFoundException e){
            System.out.println("Nie ma takiego pliku.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Bład odczytu!");
            e.printStackTrace();
        }
        return false;
    }

    private static void printFilteredFiles(List<File> allFiles) {
        for(File f: allFiles.stream().filter(fil -> fil.getName().endsWith(".png")).collect(Collectors.toList())){
            System.out.println(f);
        }
    }

    private static void addSubFiles(File file, List<File> allFiles) {
        File[] files = file.listFiles();
        if (files != null) {
            System.out.println("===================SUB_FILES===================");
            for (File subfile : files) {
                System.out.println(subfile);
                if (subfile.isFile()){
                    allFiles.add(subfile);
                } else if (subfile.isDirectory()){
                    addSubFiles(subfile, allFiles);
                }
            }
        } else {
            System.out.println("No subfiles for " + file.getName());
        }
    }
}

