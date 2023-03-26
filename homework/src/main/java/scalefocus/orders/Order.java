package scalefocus.orders;

import javax.xml.crypto.Data;

public class Order {
    private int id;
    private String clientName;//this will extend a client class later
    private String clientSurname;//this will extend a client class later
    private String book;//this will extend a book class later
    private String date1;
    private String date2;

    public Order(int id, String clientName, String clientSurname, String book, String date1, String date2) {
        this.id = id;
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.book = book;
        this.date1 = date1;
        this.date2 = date2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", clientSurname='" + clientSurname + '\'' +
                ", book='" + book + '\'' +
                ", date1='" + date1 + '\'' +
                ", date2='" + date2 + '\'' +
                '}';
    }
}
