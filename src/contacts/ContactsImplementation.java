package contacts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ContactsImplementation {
    final static String dir = "data";
    final static String fileName = "data/contacts.txt";

    public static void main(String[] args) {
        Path dirPath = Paths.get(dir);
        Path filePath = Paths.get(fileName);


        if (!Files.exists(dirPath)) {
            try {
                //does everything

                Files.createDirectory(dirPath);
                System.out.println("path = " + dirPath);
                Files.createFile(filePath);
                System.out.println("filePath = " + filePath);


            } catch (IOException e) {
                //block of code to handle errors
                e.printStackTrace();
                System.out.println("Directory creation failed.");
            }

        }
    }
}
