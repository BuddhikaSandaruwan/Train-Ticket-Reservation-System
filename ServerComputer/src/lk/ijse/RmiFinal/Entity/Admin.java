package lk.ijse.RmiFinal.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
    @Id
    private String nic;
    private String userName;
    private String password;
    private String salt;

    public Admin() {
    }

    public Admin(String nic, String userName, String password, String salt) {
        this.nic = nic;
        this.userName = userName;
        this.password = password;
        this.salt = salt;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
