package contacts;

import java.nio.file.Files;

public class Contacts {
    protected static String name;
    protected static String phoneNumber;



    //constructor
    public void setContact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    //getter
    public static String getName() {
        return name;
    }




}
