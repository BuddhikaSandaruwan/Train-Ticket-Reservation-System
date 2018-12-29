package lk.ijse.RmiFinal.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticID;

    @ManyToOne(cascade = CascadeType.ALL)
    private Shadule shaID;

    private double payment;

    @Temporal(TemporalType.DATE)
    private Date OrderDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer cusID;

    private String sheetID;



    public Ticket() {
    }

    public int getTicID() {
        return ticID;
    }

    public void setTicID(int ticID) {
        this.ticID = ticID;
    }

    public Shadule getShaID() {
        return shaID;
    }

    public void setShaID(Shadule shaID) {
        this.shaID = shaID;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date orderDate) {
        OrderDate = orderDate;
    }

    public Customer getCusID() {
        return cusID;
    }

    public void setCusID(Customer cusID) {
        this.cusID = cusID;
    }

    public String getSheetID() {
        return sheetID;
    }

    public void setSheetID(String sheetID) {
        this.sheetID = sheetID;
    }

    public Ticket(int ticID, Shadule shaID, double payment, Date orderDate, Customer cusID, String sheetID) {
        this.ticID = ticID;
        this.shaID = shaID;
        this.payment = payment;
        OrderDate = orderDate;
        this.cusID = cusID;
        this.sheetID = sheetID;
    }
}
