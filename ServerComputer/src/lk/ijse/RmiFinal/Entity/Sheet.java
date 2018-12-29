package lk.ijse.RmiFinal.Entity;

import javax.persistence.*;

@Entity
public class Sheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iD;

    private String sheetID;

    @ManyToOne(cascade = CascadeType.ALL)
    private Shadule shaID;

    private String state;

    public Sheet() {
    }



    public String getSheetID() {
        return sheetID;
    }

    public void setSheetID(String sheetID) {
        this.sheetID = sheetID;
    }

    public Shadule getShaID() {
        return shaID;
    }

    public void setShaID(Shadule shaID) {
        this.shaID = shaID;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Sheet(int iD,String sheetID, Shadule shaID, String state) {
        this.iD=iD;
        this.sheetID = sheetID;
        this.shaID = shaID;
        this.state = state;
    }
}
