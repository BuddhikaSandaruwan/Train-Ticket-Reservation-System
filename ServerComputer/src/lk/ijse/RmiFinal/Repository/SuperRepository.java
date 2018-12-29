package lk.ijse.RmiFinal.Repository;

import org.hibernate.Session;

public interface SuperRepository {
    public void setSession(Session session)throws Exception;
}
