package scalefocus.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class ConsoleReader {//utility class(all methodes are going to be static)

    private static final String INVALID_INT_MESSAGE = "%s is not an int.Try again: ";
    private static final String ORDERS_FLIE_PATH="C:\\Users\\bojan\\OneDrive\\Desktop\\Praksa\\Scalefocus-Academy-Homeworks\\Domasna 1\\Order.txt";

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
