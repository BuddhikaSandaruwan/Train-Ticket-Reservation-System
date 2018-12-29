package lk.ijse.RmiFinal.Service;

import java.rmi.Remote;

public interface ServiceFactory extends Remote {
    public enum ServiceTypes{
        CUSTOMER,TICKET,SHADULE,SHEET,RESEPTION;
    }
    public <T>T getSuperService(ServiceTypes serviceTypes)throws Exception;
}
