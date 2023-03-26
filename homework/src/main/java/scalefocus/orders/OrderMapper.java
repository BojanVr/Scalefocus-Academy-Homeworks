package scalefocus.orders;

import java.util.List;



public class OrderMapper {//to convert from one type of data to another
    public Order mapStringToOrder(String string){
        String[] tokens = string.split("_");
        int id = 0;//maybe is it mistake to do this id=0
        String clientName = tokens[1];
        String clientSurname = tokens[2];
        String book = tokens[3];
        String date1 = tokens[4];
        String date2 = tokens[5];

        try {
            id = Integer.parseInt(tokens[0]);
        }catch (NumberFormatException e){
            throw new IllegalStateException("Order with id: "+ id + " saved with invalid state");
        }
        return new Order(id,clientName,clientSurname,book,date1,date2);
    }

    public String mapOrderToString(Order order){
        int id = order.getId();
        String clientName = order.getClientName();
        String clientSurname = order.getClientSurname();
        String book = order.getBook();//this wiill extend the book class Book book
        String date1 = order.getDate1();
        String date2 = order.getDate2();

        return String.join("_",Integer.toString(id),clientName,clientSurname,book,date1,date2);
    }

    public String mapOrderListToString(List<Order> orderList){
        StringBuilder stringBuilder = new StringBuilder();

        for (Order order : orderList) {
            String orderString = mapOrderToString(order);
            stringBuilder.append(orderString).append("\n");
        }
        return stringBuilder.toString();
    }
}
