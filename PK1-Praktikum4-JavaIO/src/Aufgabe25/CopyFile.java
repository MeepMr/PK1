package Aufgabe25;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CopyFile {

    public static void main(String[] args) {

        try {

            File f1 = new File("./src/test1.txt");
            File f2 = new File("./src/test2/test.txt");

            copy(f1, f2);
        } catch (IOException e) {

            System.out.println("Error occured, catched " + e);
        }
    }

    public static void copy(File from, File to) throws IOException {

        Files.copy(from.toPath(), to.toPath());
    }
}
