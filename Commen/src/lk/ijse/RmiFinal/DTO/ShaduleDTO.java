package lk.ijse.RmiFinal.DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class ShaduleDTO implements Serializable {
    private int shaID;
    private Date date;
    private String startStation;
    private String endStation;
    private String name;
    private String arival;
    private String deputure;
    private Double price;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ShaduleDTO() {
    }

    public ShaduleDTO(int shaID, Date date, String startStation, String endStation, String name, String arival, String deputure,Double price) {
        this.shaID = shaID;
        this.date = date;
        this.startStation = startStation;
        this.endStation = endStation;
        this.name = name;
        this.arival = arival;
        this.deputure = deputure;
        this.price=price;
    }

    public int getShaID() {
        return shaID;
    }

    public void setShaID(int shaID) {
        this.shaID = shaID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArival() {
        return arival;
    }

    public void setArival(String arival) {
        this.arival = arival;
    }

    public String getDeputure() {
        return deputure;
    }

    public void setDeputure(String deputure) {
        this.deputure = deputure;
    }
}
