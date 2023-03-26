package scalefocus.util;

import java.util.Scanner;

public final class ConsoleReader {//utility class(all methodes are going to be static)

    private static final String INVALID_INT_MESSAGE = "%s is not an int.Try again: ";

    private static final Scanner input = new Scanner(System.in);


    private ConsoleReader(){
        throw new UnsupportedOperationException();
    }

    public static String readStringFromInput(){
        return input.nextLine();
    }

    public static int readIntFromInput(){
        while (!input.hasNextInt()){
            String inputString = input.next();
            System.out.printf(INVALID_INT_MESSAGE,inputString);
        }
        int inputInt = input.nextInt();
        input.nextLine();//this is a must when you call nexInt()
        return inputInt;
    }

    public static String readString() {
        while (!input.hasNext()){
            String inputString = input.next();
            System.out.printf(INVALID_INT_MESSAGE,inputString);
        }
        String inputString = input.next();
        input.nextLine();//this is a must when you call nexInt()
        return inputString;
    }
}
