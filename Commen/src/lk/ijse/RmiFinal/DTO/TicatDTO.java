package lk.ijse.RmiFinal.DTO;

import java.io.Serializable;
import java.util.Date;

public class TicatDTO implements Serializable {
    private int ticID;
    private Date date;
    private Double payment;
    private String SheetID;
    private String custId;
    private int shaID;

    public TicatDTO() {
    }

    public TicatDTO(int ticID, Date date, Double payment, String sheetID, String custId) {
        this.ticID = ticID;
        this.date = date;
        this.payment = payment;
        SheetID = sheetID;
        this.custId = custId;
    }

    public int getTicID() {
        return ticID;
    }

    public void setTicID(int ticID) {
        this.ticID = ticID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public String getSheetID() {
        return SheetID;
    }

    public void setSheetID(String sheetID) {
        SheetID = sheetID;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public int getShaID() {
        return shaID;
    }

    public void setShaID(int shaID) {
        this.shaID = shaID;
    }
}
