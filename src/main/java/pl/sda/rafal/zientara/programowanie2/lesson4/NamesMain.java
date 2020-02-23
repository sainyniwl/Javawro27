package pl.sda.rafal.zientara.programowanie2.lesson4;

import java.io.*;

public class NamesMain {

    public static void main(String[] args) {
        System.out.println(new File("").getAbsolutePath());
        String fileName = "maleNames.txt";
        String[] maleNames = getNamesFromFile(fileName);


    }

    private static String[] getNamesFromFile(String fileName) {
        String allNames = getFileData(fileName);
        return getNormalizedNames(allNames);
    }

    private static String getFileData(String fileName) {
        String allNames = "";
        File file = new File(fileName);
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            allNames = bufferedReader.readLine();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allNames;
    }

    private static String[] getNormalizedNames(String allNames) {
        String[] names;
        names = allNames.split(",");

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            name = name.trim();
            System.out.println("#" + name + "#");
            names[i] = name;
        }
        return names;
    }
}
