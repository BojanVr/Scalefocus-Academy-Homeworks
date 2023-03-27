package scalefocus.clients;

import scalefocus.util.ConsoleRangeReader;
import scalefocus.util.ConsoleReader;

import java.util.List;

public class ClientPresenter {
    private static final String OPTIONS_MESSAGE = "Welcome to the Client Creation menu!\n" + "Please select what you want to do:\n" + "1. All clients\n" + "2. Create client\n" + "3. Edit client\n" + "4. Delete client\n" + "5. Back";
    private static final String ID_MESSAGE = "Enter the id you want to edit: ";
    private static final String CLIENT_NAME_MESSAGE = "Enter the client's name: ";
    private static final String CLIENT_SURNAME_MESSAGE = "Enter the client's surname: ";

    private static final int MIN_MENU_VALUE = 1;
    private static final int MAX_MENU_VALUE = 5;

    private static final ClientService clientService = new ClientService();

    public void OrderMenu() {
        System.out.println(OPTIONS_MESSAGE);
        int choice = ConsoleRangeReader.readInt(MIN_MENU_VALUE, MAX_MENU_VALUE);
        //System.out.println("You chose " + choice);
        switch (choice) {
            case 1:
                printAllClients();
                break;
            case 2:
                addClient();
                break;
            case 3:
                editClient();
                break;
            case 4:
                removeClient();
                break;
            case 5:
                break;
        }
    }

    public void printAllClients() {
        List<Client> clients = clientService.getAllClients();
        for (Client client : clients) {
            System.out.println(client);
        }
    }

    public void addClient() {
        System.out.println(CLIENT_NAME_MESSAGE);
        String clientName = ConsoleReader.readString();
        System.out.println(CLIENT_SURNAME_MESSAGE);
        String clientSurname = ConsoleReader.readString();

        clientService.addClient(clientName,clientSurname);
    }

    public void editClient() {
        System.out.println(ID_MESSAGE);
        int id = ConsoleReader.readIntFromInput();

        System.out.println(CLIENT_NAME_MESSAGE);
        String clientName = ConsoleReader.readString();
        System.out.println(CLIENT_SURNAME_MESSAGE);
        String clientSurname = ConsoleReader.readString();

        clientService.editClient(id,clientName,clientSurname);
    }

    public void removeClient() {
        System.out.println(ID_MESSAGE);
        int id = ConsoleReader.readIntFromInput();

        clientService.removeClient(id);
    }
}
