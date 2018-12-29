package lk.ijse.RmiFinal.DTO;

import java.io.Serializable;

public class ReseptionDTO implements Serializable {
    private String rNIC;
    private String uName;
    private String password;
    private String salt;

    public ReseptionDTO() {
    }

    public ReseptionDTO(String rNIC, String uName, String password, String salt) {
        this.rNIC = rNIC;
        this.uName = uName;
        this.password = password;
        this.salt = salt;
    }

    public String getrNIC() {
        return rNIC;
    }

    public void setrNIC(String rNIC) {
        this.rNIC = rNIC;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
