package lk.ijse.RmiFinal.DTO;

import java.io.Serializable;

public class SheetDTO implements Serializable {

    private  int id;
    private String sheetID;
    private String state;
    private int ShaID;

    public SheetDTO() {
    }

    public SheetDTO(String sheetID, String state, int shaID) {
        this.sheetID = sheetID;
        this.state = state;
        ShaID = shaID;
    }

    public SheetDTO(int id, String state, int shaID) {
        this.id = id;
        this.state = state;
        ShaID = shaID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSheetID() {
        return sheetID;
    }

    public void setSheetID(String sheetID) {
        this.sheetID = sheetID;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getShaID() {
        return ShaID;
    }

    public void setShaID(int shaID) {
        ShaID = shaID;
    }
}
