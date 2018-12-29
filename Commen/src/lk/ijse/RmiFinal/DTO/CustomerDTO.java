package lk.ijse.RmiFinal.DTO;

import java.io.Serializable;

public class CustomerDTO implements Serializable {
    private String cusID;
    private String cusName;
    private String cusAdress;
    private int cusTP;

    public CustomerDTO() {
    }

    public CustomerDTO(String cusID, String cusName, String cusAdress, int cusTP) {
        this.cusID = cusID;
        this.cusName = cusName;
        this.cusAdress = cusAdress;
        this.cusTP = cusTP;
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
}
