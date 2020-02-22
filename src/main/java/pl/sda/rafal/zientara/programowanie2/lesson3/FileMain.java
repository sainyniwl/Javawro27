package pl.sda.rafal.zientara.programowanie2.lesson3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileMain {
    public static void main(String[] args) {
        File file = new File("C:\\data\\");
        System.out.println(file.getAbsolutePath());
        System.out.println("Exists :" + file.exists());
        System.out.println("Exists :" + file.getParent());
        System.out.println("Exists :" + file.isDirectory());
        System.out.println("Exists :" + file.isFile());

        List<File> fileList = new ArrayList<>();


        addSubFiles(file, fileList);

        System.out.println("=========== FINAL RESULT =========");

        List<File> pngFiles = fileList.stream()
                .filter(fil -> fil.getName().endsWith(".png"))
                .collect(Collectors.toList());
        for (File png : pngFiles
        ) {
            System.out.println("Checking duplicates for " + png);
            List<File> duplicates = getDuplicates(png, pngFiles);
            System.out.println("Duplicates " + duplicates);
            deleteDuplicates(duplicates);

            //todo inne usuwanie z listy

        }
//print filtered files
     /*   for (File f : fileList.stream()
                .filter(fil -> fil.getName().endsWith(".txt"))
                .collect(Collectors.toList())
        ) {
            System.out.println(f);
        }*/
    }

    private static void deleteDuplicates(List<File> duplicates) {
        for (File dup : duplicates
        ) {
            boolean delete = dup.delete();
            if (delete) {
                System.out.println("Deleted " + dup.length());
            } else {
                System.out.println("Cant remove");
            }
        }
    }

    private static List<File> getDuplicates(File png, List<File> pngFiles) {
        List<File> duplicates = new ArrayList<>();
        for (File possibleDuplicates : pngFiles
        ) {
            if (isDuplicates(png, possibleDuplicates)) {
                duplicates.add(possibleDuplicates);
            }
        }
        return duplicates;
    }

    private static boolean isDuplicates(File png, File possibleDuplicates) {
        if (png.getAbsolutePath().equals(possibleDuplicates.getAbsolutePath())) {
            return false;
        }
        if (png.length() == possibleDuplicates.length()) {
            //todo porownaj pliki d
            return compareBybBites(png, possibleDuplicates);
        } else {
            return false;
        }
    }

    private static boolean compareBybBites(File png, File possibleDuplicates) {
        try {
            FileReader reader = new FileReader(png);
            FileReader reader2 = new FileReader(possibleDuplicates);
            int read1;
            int read2;
            do {
                read1 = reader.read();
                read2 = reader2.read();
                if (read1 != read2) {
                    System.out.println("Different! " + read1 + "!=" + read2);
                    reader.close();
                    reader2.close();
                    return false;
                }
            } while (read1 != -1 && read2 != -1);

            reader.close();
            reader2.close();
            return true;

        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Can't read");
            e.printStackTrace();
        }
        return false;
    }

    private static void addSubFiles(File file, List<File> fileList) {
        File[] files = file.listFiles();
        System.out.println("=========== sub files =========");
        if (files != null) {
            for (File subFile : files
            ) {
                System.out.println(subFile);
                if (subFile.isFile()) {
                    fileList.add(subFile);
                } else if ((subFile.isDirectory())) {
                    addSubFiles(subFile, fileList);
                }
            }
        } else {
            System.out.println("No sub files" + file.getName());
        }
    }
}
