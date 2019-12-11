package contacts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import util.Input;


public class ContactsImplementation {
    final static String folder = "data";
    final static String fileName = "data/contacts.txt";




    public static void showOptions(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void showContacts(List contactListLine){
        for (int i = 0; i < contactListLine.size(); i += 1) {
            System.out.println((i) + ": " + contactListLine.get(i));
        }
    }


    public static void main(String[] args) {


        //make directory path object
        Path dirPath = Paths.get(folder);
        Path filePath = Paths.get(fileName);

        //user input obj
        Input input = new Input();

        //scanner obj
        Scanner sc = new Scanner(System.in);

//        Path ContactNamePath = Paths.get("data", "contacts.txt");
//
//
//        List<String> ContactNamesList = Arrays.asList("Nico | 210-123-4523", "Roger | 210-342-4454", "Fer | 210-234-4524");



        try {
            Path ContactNamePath = Paths.get("data", "contacts.txt");

            if (!Files.exists(filePath) && !Files.exists(dirPath)) {


                List<String> ContactNamesList = Arrays.asList("Nico | 210-123-4523", "Roger | 210-342-4454", "Fer | 210-234-4524");

                //create data directory
                Files.createDirectory(dirPath);
                //create file directory
                Files.createFile(filePath);

                //write on the file
                Files.write(ContactNamePath, ContactNamesList);
            }





            //turn lines to strings, store in list
            List<String> contactListLine = Files.readAllLines(ContactNamePath);


                showOptions();
                boolean flag = true;
                do {
                    switch (input.getInt()) {
                        case 1:
                            contactListLine = Files.readAllLines(ContactNamePath);
                            showContacts(contactListLine);
                            showOptions();
                            break;
                        case 2:

                            System.out.println("Add a new contact:");
                            input.getString();
                            String newContact = input.getString();
                            List<String> addTempContactList = Files.readAllLines(Paths.get("data", "contacts.txt"));
                            Files.write(ContactNamePath, addTempContactList);
                            Files.write(
                                    ContactNamePath,
                                    Arrays.asList(newContact),
                                    StandardOpenOption.APPEND
                            );
                            showOptions();
                            break;
                        case 3:
                            System.out.println("Search a contact by name: ");

                            //read lines for search
                            List<String> searchContactList = Files.readAllLines(Paths.get("data", "contacts.txt"));
                            showContacts(searchContactList);
                            //bucket
                            List<String> searchBucket = new ArrayList<>();

                            String searchInput = sc.nextLine();
                            for(String contact : searchContactList) {
                                //if contains name, print

                                if(contact.contains(searchInput)){
                                    System.out.println(contact);
                                    continue;
                                }
                                searchBucket.add(contact);
                            }
                            Files.write(filePath, searchBucket);

                            showOptions();
                            break;
                        case 4:
                            System.out.println("Delete an existing contact:");

                            //read all lines from data/contacts.txt, storing in newContactsList
                            List<String> newContactList = Files.readAllLines(Paths.get("data", "contacts.txt"));
                            //bucket
                            List<String> tempList = new ArrayList<>();

                            //new input to get value from user
                            String dltInput = sc.nextLine();
                            for (String contact : newContactList) {
                                //if contains name, delete (be careful because common strings will delete the whole thing)

                                if (contact.contains(dltInput)) {
                                    continue;

                                }
                                tempList.add(contact);
                            }
                            Files.write(filePath, tempList);
                            showOptions();
                            break;
                        case 5:
                            System.out.println("Exit");
                            flag = false;
                            break;
                        default:
                            System.out.println("Invalid input: ");
                            showOptions();
                           input.getString();
                    }
                } while (flag);


        } catch (IOException e) {
            //block of code to handle errors
            e.printStackTrace();
            System.out.println("Directory creation failed.");

        }
    }
}
