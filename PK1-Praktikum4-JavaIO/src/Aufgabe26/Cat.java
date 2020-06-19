package Aufgabe26;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Cat {

    public static void main(String[] args) {

        File f1 = new File("./src/test1.txt");

        try {

            cat(f1);
        } catch (IOException e){

            System.out.println("Catched something");
        }

    }

    public static void cat(File quelle) throws IOException {

        RandomAccessFile f = new RandomAccessFile(quelle, "r");
        byte [] b = new byte[1024];
        f.read(b, 0, 1024);

        String s = new String(b);
        System.out.println(s);
    }
}
