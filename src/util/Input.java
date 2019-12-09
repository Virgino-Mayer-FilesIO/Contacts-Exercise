package util;

import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);

    public String getString(){
        return scanner.nextLine();
    }

    public boolean yesNo(){
        String input = scanner.next();
        return (input.equalsIgnoreCase("yes")||input.equalsIgnoreCase("y")||input.equalsIgnoreCase("yeah"));
    }

    public int getInt(int min, int max){
        int input = scanner.nextInt();
        while(input < min || input > max){
            input = scanner.nextInt();
        }
        return input;
    }

    public int getInt(){
        return scanner.nextInt();
    }

    public double getDouble(double min, double max){
        double input = scanner.nextDouble();
        while(input < min || input > max){
            input = scanner.nextDouble();
        }
        return input;
    }

    public double getDouble(){
        return scanner.nextDouble();
    }


}


