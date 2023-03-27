package scalefocus.clients;

import scalefocus.orders.Order;

import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private static final ClientAccessor clientAccessor = new ClientAccessor();
    private static final ClientMapper clientMapper = new ClientMapper();

    public List<Client> getAllClients() {
        List<String> clientStrings = clientAccessor.readAllClients();
        List<Client> clients = new ArrayList<>();
        for (String clientString : clientStrings) {
            Client client = clientMapper.mapStringToClient(clientString);
            clients.add(client);
        }
        return clients;
    }

    public void addClient(String clientName, String clientSurname) {
        int id = clientAccessor.readAllClients().size() + 1;
        Client client = new Client(id, clientName, clientSurname);
        String clientString = clientMapper.mapClientToString(client);
        clientAccessor.addClient(clientString);
    }

    public void editClient(int id, String clientName, String clientSurname) {
        List<Client> clients = getAllClients();
        Client clientToEdit = getClientById(id, clients);
        if (clientToEdit == null) {
            return;
        }
        clientToEdit.setName(clientName);
        clientToEdit.setSurname(clientSurname);



        String clientsString = clientMapper.mapClientListToString(clients);
        clientAccessor.overwriteFile(clientsString);
    }

    public void removeClient(int id) {
        List<Client> clients = getAllClients();

        Client clientToRemove = getClientById(id, clients);

        if (clientToRemove == null) {
            return;
        }

        clients.remove(clientToRemove);
        for (int i = clientToRemove.getId() - 1; i < clients.size(); i++) {
            clients.get(i).setId(i + 1);
        }

        String clientsString = clientMapper.mapClientListToString(clients);
        clientAccessor.overwriteFile(clientsString);
    }

    private Client getClientById(int id, List<Client> clients) {
        if (id > clients.size() || id < 1) {
            System.out.println("Id dosen't exist");
            return null;
        }
        Client client = null;
        for (Client clientInList : clients) {
            if (clientInList.getId() == id) {
                client = clientInList;
                break;
            }
        }
        return client;
    }
}
