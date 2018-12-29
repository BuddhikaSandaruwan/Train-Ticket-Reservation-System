package lk.ijse.RmiFinal.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reseption {
    @Id
    private String rNIC;
    private String uName;
    private String password;
    private String salt;

    public Reseption() {
    }

    public Reseption(String rNIC, String uName, String password, String salt) {
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
