package scalefocus.clients;

import scalefocus.orders.Order;

import java.util.List;

public class ClientMapper {
    public Client mapStringToClient(String string){
        String[] tokens = string.split("_");
        if (tokens.length < 3) {
            throw new IllegalArgumentException("Invalid input string: " + string);
        }
        int id;
        String clientName = tokens[1];
        String clientSurname = tokens[2];

        try {
            id = Integer.parseInt(tokens[0]);
        } catch (NumberFormatException e) {
            throw new IllegalStateException("Client with id: " + clientName + " saved with invalid state");
        }
        return new Client(id,clientName,clientSurname);
    }

    public String mapClientToString(Client client){
        int id = client.getId();
        String clientName = client.getName();
        String clientSurname = client.getSurname();

        return String.join("_",Integer.toString(id),clientName,clientSurname);
    }

    public String mapClientListToString(List<Client> clientList){
        StringBuilder stringBuilder = new StringBuilder();

        for (Client client : clientList) {
            String orderString = mapClientToString(client);
            stringBuilder.append(orderString).append("\n");
        }
        return stringBuilder.toString();
    }
}
