package lk.ijse.RmiFinal.Observer;

import java.rmi.Remote;

public interface Observer extends Remote {
    public void update()throws Exception;
}
