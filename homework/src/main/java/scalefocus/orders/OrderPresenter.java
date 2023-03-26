package scalefocus.orders;

import scalefocus.util.ConsoleRangeReader;
import scalefocus.util.ConsoleReader;

import java.util.List;

public class OrderPresenter {//print and read from the console
    private static final String OPTIONS_MESSAGE = "Welcome to the Order Managment menu!\n" + "Please select what you want to do:\n" + "1. Order information\n" + "2. Create order\n" + "3. Edit order\n" + "4. Delete order\n" + "5. Back";
    private static final String ID_MESSAGE = "Enter the id you want to edit: ";
    private static final String CLIENT_NAME_MESSAGE = "Enter the client's name: ";
    private static final String CLIENT_SURNAME_MESSAGE = "Enter the client's surname: ";
    private static final String BOOK_NAME_MESSAGE = "Enter the books's name: ";
    private static final String DUE_DATE_MESSAGE = "Enter the due date: ";
    private static final String END_DATE_MESSAGE = "Enter the end date: ";

    private static final int MIN_MENU_VALUE = 1;
    private static final int MAX_MENU_VALUE = 5;

    private static final OrderService orderService = new OrderService();

    public void OrderMenu() {
        System.out.println(OPTIONS_MESSAGE);
        int choice = ConsoleRangeReader.readInt(MIN_MENU_VALUE, MAX_MENU_VALUE);
        //System.out.println("You chose " + choice);
        switch (choice) {
            case 1:
                printAllOrders();
                break;
            case 2:
                addOrder();
                break;
            case 3:
                editOrder();
                break;
            case 4:
                removeOrder();
                break;
            case 5:
                System.out.println("back later..");
                break;
        }
    }

    public void printAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public void addOrder() {
        System.out.println(CLIENT_NAME_MESSAGE);
        String clientName = ConsoleReader.readString();
        System.out.println(CLIENT_SURNAME_MESSAGE);
        String clientSurname = ConsoleReader.readString();
        System.out.println(BOOK_NAME_MESSAGE);
        String book = ConsoleReader.readString();
        System.out.println(DUE_DATE_MESSAGE);
        String date1 = ConsoleReader.readString();
        System.out.println(END_DATE_MESSAGE);
        String date2 = ConsoleReader.readString();

        orderService.addOrder(clientName,clientSurname,book,date1,date2);
    }

    public void editOrder() {
        System.out.println(ID_MESSAGE);
        int id = ConsoleReader.readIntFromInput();

        System.out.println(CLIENT_NAME_MESSAGE);
        String clientName = ConsoleReader.readString();
        System.out.println(CLIENT_SURNAME_MESSAGE);
        String clientSurname = ConsoleReader.readString();
        System.out.println(BOOK_NAME_MESSAGE);
        String book = ConsoleReader.readString();
        System.out.println(DUE_DATE_MESSAGE);
        String date1 = ConsoleReader.readString();
        System.out.println(END_DATE_MESSAGE);
        String date2 = ConsoleReader.readString();

        orderService.editOrder(id,clientName,clientSurname,book,date1,date2);
    }

    public void removeOrder() {
        System.out.println(ID_MESSAGE);
        int id = ConsoleReader.readIntFromInput();

        orderService.removeOrder(id);
    }



}
