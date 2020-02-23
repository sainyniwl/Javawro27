package pl.sda.rafal.zientara.programowanie2.lesson4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NamesMain {

    public static void main(String[] args) {

        loadNames("femaleNames.txt");

    }

    private static String[] loadNames(String fileName) {
        String[] names;
        File file = new File(fileName);
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String data = bufferedReader.readLine();
            reader.close();
            names = data.split(",");
            for (int i = 0; i < names.length; i++) {
                String name = names[i];
                name.trim();
                names[i] = name;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
