package contacts;

public class Contacts {
    protected static String name;
    protected static String phoneNumber;


    //constructor
    public void setContact(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    //getter
    public void getContact(){
        System.out.println(this.name + this.phoneNumber);
    }


}
