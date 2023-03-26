package scalefocus.orders;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private static final OrderAccessor orderAccessor = new OrderAccessor();
    private static final OrderMapper orderMapper = new OrderMapper();

    public List<Order> getAllOrders() {
        List<String> orderStrings = orderAccessor.readAllOrders();
        List<Order> orders = new ArrayList<>();
        for (String orderString : orderStrings) {
            Order order = orderMapper.mapStringToOrder(orderString);
            orders.add(order);
        }
        return orders;
    }

    public void addOrder(String clientName, String clientSurname, String book, String date1, String date2) {
        int id = orderAccessor.readAllOrders().size() + 1;
        Order order = new Order(id, clientName, clientSurname, book, date1, date2);
        String orderString = orderMapper.mapOrderToString(order);
        orderAccessor.addOrder(orderString);
    }

    public void editOrder(int id, String clientName, String clientSurname, String book, String date1, String date2) {
        List<Order> orders = getAllOrders();
        Order orderToEdit = getOrderById(id, orders);
        if (orderToEdit == null) {
            return;
        }
        orderToEdit.setClientName(clientName);
        orderToEdit.setClientSurname(clientSurname);
        orderToEdit.setBook(book);
        orderToEdit.setBook(date1);
        orderToEdit.setBook(date2);


        String ordersString = orderMapper.mapOrderListToString(orders);
        orderAccessor.overwriteFile(ordersString);
    }

    public void removeOrder(int id) {
        List<Order> orders = getAllOrders();

        Order orderToRemove = getOrderById(id, orders);

        if (orderToRemove == null) {
            return;
        }

        orders.remove(orderToRemove);
        for (int i = orderToRemove.getId() - 1; i < orders.size(); i++) {
            orders.get(i).setId(i + 1);
        }

        String ordersString = orderMapper.mapOrderListToString(orders);
        orderAccessor.overwriteFile(ordersString);
    }

    private Order getOrderById(int id, List<Order> orders) {
        if (id > orders.size() || id < 1) {
            System.out.println("Id dosen't exist");
            return null;
        }
        Order order = null;
        for (Order orderInList : orders) {
            if (orderInList.getId() == id) {
                order = orderInList;
                break;
            }
        }
        return order;
    }
}
