package contacts;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import util.Input;

public class ContactsImplementation {
    final static String folder = "data";
    final static String fileName = "data/contacts.txt";


    public static void main(String[] args) {
        //make directory path object
        Path dirPath = Paths.get(folder);
        Path filePath = Paths.get(fileName);

        Path ContactNamePath = Paths.get("data", "contacts.txt");

        HashMap<String, String> contacts = new HashMap<>();

        List<String> ContactNamesList = Arrays.asList("Nico", "Roger", "Fer");


        try {
            if (!Files.exists(dirPath)) {
                //does everything

                //create data directory
                Files.createDirectory(dirPath);
                System.out.println("path = " + dirPath);

                //create file directory
                Files.createFile(filePath);
                System.out.println("filePath = " + filePath);

                Files.write(ContactNamePath, ContactNamesList);

                //turn lines to strings, store in list
                List<String> contactListLine = Files.readAllLines(ContactNamePath);


                //create bucket (for added stuff)
                List<String> tempList = new ArrayList<>();

                //for to print
                for (int i = 0; i < contactListLine.size(); i += 1) {
                    System.out.println((i + 1) + ": " + contactListLine.get(i));
                }
            }
        } catch (IOException e) {
            //block of code to handle errors
            e.printStackTrace();
            System.out.println("Directory creation failed.");
        }
    }
}
