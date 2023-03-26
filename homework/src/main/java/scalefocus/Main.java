package scalefocus;

import scalefocus.orders.OrderAccessor;
import scalefocus.orders.OrderPresenter;
import scalefocus.util.ConsoleRangeReader;
import scalefocus.util.ConsoleReader;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String GREETING_MESSAGE = "Welcome to Library Management Application!\n" +
            "Please choose a menu, to proceed further:\n" +
            "1. Order Management\n" +
            "2. Book Management\n" +
            "3. Client Creation\n" +
            "4. Author Creation\n" +
            "5. End";
    private static final String PLACEHOLDER_1 = "Books later";
    private static final String PLACEHOLDER_2 = "Client later";
    private static final String PLACEHOLDER_3 = "Author later";
    private static final String PLACEHOLDER_4 = "Bye";

    private static final OrderPresenter orderPresenter = new OrderPresenter();//presenting the order menu

    private static final int MIN_MENU_VALUE = 1;
    private static final int MAX_MENU_VALUE = 5;
    public static void main(String[] args) {
        while (true) {
            System.out.println(GREETING_MESSAGE);//presenting the order menu
            int choice = ConsoleRangeReader.readInt(MIN_MENU_VALUE,MAX_MENU_VALUE);

            switch (choice) {
                case 1:
                    orderPresenter.OrderMenu();
                    break;
                case 2:
                    System.out.println(PLACEHOLDER_1);
                    break;
                case 3:
                    System.out.println(PLACEHOLDER_2);
                    break;
                case 4:
                    System.out.println(PLACEHOLDER_3);
                    break;
                case 5:
                    System.out.println(PLACEHOLDER_4);
                    return;//if you chose back just break
            }
        }
    }
}
