package pl.sda.rafal.zientara.programowanie2.lesson4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ByteFileComparator {

   public boolean compareByBytes(File png, File possibleDuplicate){

       try {

           long startTime = System.currentTimeMillis();
           FileReader reader1 = new FileReader(png);
           FileReader reader2 = new FileReader(possibleDuplicate);
           //  int BUFFER_SIZE = 1;
           char[] buffer1 = new char[1024];
           char[] buffer2 = new char[1024];


           int read1;
           int read2;
           do {
               read1 = reader1.read(buffer1);
               read2 = reader2.read(buffer2);
               if (read1 != read2) {
                   System.out.println("Inne! " + read1 + "!=" + read2);
                   reader1.close();
                   reader2.close();

                   long end = System.currentTimeMillis();
                   long diff = end - startTime;
                   System.out.println("Nie duplikat! Zmarnowałem [ms] " + diff);
                   return false;
                   //plik1:11111111
                   //plik2:11111101
               } else {
                   for (int i = 0; i < buffer1.length; i++) {
                       char c1 = buffer1[i];
                       char c2 = buffer2[i];
                       if (c1 != c2) {
                           long end = System.currentTimeMillis();
                           long diff = end - startTime;
                           System.out.println("Nie duplikat! Zmarnowałem [ms] " + diff);
                           return false;
                       }
                   }
               }
           } while (read1 != -1 && read2 != -1);

           //todo sprawdz jeszcze raz read1 i read2
           reader1.close();
           reader2.close();

           long end = System.currentTimeMillis();
           long diff = end - startTime;
           System.out.println("Duplikat! Znaleziono po [ms] " + diff);

           return true;
       } catch (FileNotFoundException e) {
           System.out.println("Nie ma takiego pliku!");
           e.printStackTrace();
       } catch (IOException e) {
           System.out.println("Błąd odczytu!");
           e.printStackTrace();
       }

       return false;
   }

}
