package contacts;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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

        //user input obj
        Input input = new Input();

        //scanner obj
        Scanner sc = new Scanner(System.in);

        Path ContactNamePath = Paths.get("data", "contacts.txt");

        HashMap<String, String> contacts = new HashMap<>();

        List<String> ContactNamesList = Arrays.asList("Nico | 210-123-4523", "Roger | 210-342-4454", "Fer | 210-234-4524");


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


                //for to print
                // view contacts here
                //////////////////////
//                for (int i = 0; i < contactListLine.size(); i += 1) {
//                    System.out.println((i) + ": " + contactListLine.get(i));
//                }
                // 2. have an option to add a new contact
                System.out.println("1. View contacts.\n" +
                        "2. Add a new contact.\n" +
                        "3. Search a contact by name.\n" +
                        "4. Delete an existing contact.\n" +
                        "5. Exit.\n" +
                        "Enter an option (1, 2, 3, 4 or 5):");
                //user input
//                input.getInt();
//                sc.nextInt();
                boolean flag = true;
                do {
                    switch (input.getInt()) {
                        case 1:
                            for (int i = 0; i < contactListLine.size(); i += 1) {
                                System.out.println((i) + ": " + contactListLine.get(i));
                            }
                            break;
                        case 2:
                            System.out.println("Add a new contact:");
                            input.getString();
                            String newContact = input.getString();
                            Files.write(ContactNamePath, ContactNamesList);
                            Files.write(
                                    ContactNamePath,
                                    Arrays.asList(newContact),
                                    StandardOpenOption.APPEND
                            );
                            break;
                        case 3:
                            System.out.println("Search a contact by name: ");
                            //store scanner next line into a string contact variable
                            break;
                        case 4:
                            System.out.println("Delete an existing contact.");
                            //read all lines from data/contacts.txt, storing in newContactsList
                            List<String> newContactList = Files.readAllLines(Paths.get("data", "contacts.txt"));
                            //bucket
                            List<String> tempList = new ArrayList<>();

                            //new input to get value from user
                            String dltInput = sc.nextLine();
                            for (String contact : newContactList) {
                                //if contains name, delete (be careful because common strings will delete the whole thing)

                                if (contact.contains(dltInput)) {
                                    //need to refactor to make user friendly


                                    continue;

                                }
                                tempList.add(contact);
                            }
                            Files.write(filePath, tempList);

                            break;
                        case 5:
                            System.out.println("Exit");
                            flag = false;
                            break;
                        default:
                            System.out.println("Invalid input: ");
                            System.out.println("~~~~~~~~~~~~~~~~~~~~");
                            System.out.println("1. View contacts.\n" +
                                    "2. Add a new contact.\n" +
                                    "3. Search a contact by name.\n" +
                                    "4. Delete an existing contact.\n" +
                                    "5. Exit.\n" +
                                    "Enter an option (1, 2, 3, 4 or 5):");
                           input.getString();
                    }
                } while (flag);
            }

        } catch (IOException e) {
            //block of code to handle errors
            e.printStackTrace();
            System.out.println("Directory creation failed.");

        }
    }
}
