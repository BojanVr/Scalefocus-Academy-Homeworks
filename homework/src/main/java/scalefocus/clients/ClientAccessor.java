package scalefocus.clients;

import scalefocus.orders.OrderAccessor;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class ClientAccessor {
    private static final String CLIENT_FLIE_PATH="C:\\Users\\bojan\\OneDrive\\Desktop\\Praksa\\Scalefocus-Academy-Homeworks\\Domasna 1\\Homework\\Clients.txt";

    public void addClient(String string){
        try(BufferedWriter writer= new BufferedWriter(new FileWriter(CLIENT_FLIE_PATH,true))) {
            writer.write("\n");
            writer.write(string);
            //writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Invalid format "+e);
        }
    }



    public List<String> readAllClients(){//this is to read the txt file
        try(BufferedReader reader= new BufferedReader(new FileReader(CLIENT_FLIE_PATH))) {
            return reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Invalid format "+e);
        }
    }

    public void overwriteFile(String orders){
        try(BufferedWriter writer= new BufferedWriter(new FileWriter(CLIENT_FLIE_PATH))) {
            writer.write(orders);
        } catch (IOException e) {
            throw new RuntimeException("Invalid format "+e);
        }
    }

}
