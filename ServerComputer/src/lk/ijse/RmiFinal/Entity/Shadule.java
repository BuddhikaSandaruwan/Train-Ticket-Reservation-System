package lk.ijse.RmiFinal.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Shadule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int shaID;
    private String trainName;
    private String startTime;
    private String endTime;
    private String startStation;
    private String endStation;
    @Temporal(TemporalType.DATE)
    private Date day;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @OneToMany(mappedBy = "shaID",cascade = CascadeType.ALL)
    private List<Ticket> shadules=new ArrayList<>();

    @OneToMany(mappedBy = "shaID",cascade = CascadeType.ALL)
    private List<Sheet> sheets=new ArrayList<>();

    public Shadule() {
    }


    public int getShaID() {
        return shaID;
    }

    public void setShaID(int shaID) {
        this.shaID = shaID;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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

    public List<Ticket> getShadules() {
        return shadules;
    }

    public void setShadules(List<Ticket> shadules) {
        this.shadules = shadules;
    }

    public List<Sheet> getSheets() {
        return sheets;
    }

    public void setSheets(List<Sheet> sheets) {
        this.sheets = sheets;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Shadule(int shaID, String trainName, String startTime, String endTime, String startStation, String endStation, Date day, List<Ticket> shadules, List<Sheet> sheets) {
        this.shaID = shaID;
        this.trainName = trainName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startStation = startStation;
        this.endStation = endStation;
        this.day = day;
        this.shadules = shadules;
        this.sheets = sheets;
    }
    public Shadule(int shaID, String trainName, String startTime, String endTime, String startStation, String endStation, Date day,double price) {
        this.shaID = shaID;
        this.trainName = trainName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startStation = startStation;
        this.endStation = endStation;
        this.day = day;
        this.price=price;
    }
    public Shadule(int shaID) {
        this.shaID = shaID;
    }
}
