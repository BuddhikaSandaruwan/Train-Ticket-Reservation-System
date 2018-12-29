package lk.ijse.RmiFinal.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    private String cusID;
    private String cusName;
    private String cusAdress;
    private int cusTP;

    @OneToMany(mappedBy = "cusID",cascade = CascadeType.ALL)
    private List<Ticket> tickets=new ArrayList<>();

    public Customer() {
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusAdress() {
        return cusAdress;
    }

    public void setCusAdress(String cusAdress) {
        this.cusAdress = cusAdress;
    }

    public int getCusTP() {
        return cusTP;
    }

    public void setCusTP(int cusTP) {
        this.cusTP = cusTP;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Customer(String cusID, String cusName, String cusAdress, int cusTP, List<Ticket> tickets) {
        this.cusID = cusID;
        this.cusName = cusName;
        this.cusAdress = cusAdress;
        this.cusTP = cusTP;
        this.tickets = tickets;
    }

    public Customer(String cusID, String cusName, String cusAdress, int cusTP) {
        this.cusID = cusID;
        this.cusName = cusName;
        this.cusAdress = cusAdress;
        this.cusTP = cusTP;
    }
}
