package scalefocus.orders;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class OrderAccessor {//this class is used to read and write into the order.txt file
    private static final String ORDERS_FLIE_PATH="C:\\Users\\bojan\\OneDrive\\Desktop\\Praksa\\Scalefocus-Academy-Homeworks\\Domasna 1\\Order.txt";


    public void addOrder(String string){
        try(BufferedWriter writer= new BufferedWriter(new FileWriter(ORDERS_FLIE_PATH,true))) {
            writer.write(string+"\n");
            //writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Invalid format "+e);
        }
    }

    public List<String> readAllOrders(){//this is to read the txt file
        try(BufferedReader reader= new BufferedReader(new FileReader(ORDERS_FLIE_PATH))) {
            return reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Invalid format "+e);
        }
    }

    public void overwriteFile(String orders){
        try(BufferedWriter writer= new BufferedWriter(new FileWriter(ORDERS_FLIE_PATH))) {
            writer.write(orders);
        } catch (IOException e) {
            throw new RuntimeException("Invalid format "+e);
        }
    }
}
