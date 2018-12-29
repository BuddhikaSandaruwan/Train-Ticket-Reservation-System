package lk.ijse.RmiFinal.Service.Impl;

import lk.ijse.RmiFinal.Service.Custom.CustomerService;
import lk.ijse.RmiFinal.Service.Custom.Impl.*;
import lk.ijse.RmiFinal.Service.ServiceFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceFactoryImpl extends UnicastRemoteObject implements ServiceFactory {

    public ServiceFactoryImpl() throws Exception {
    }

    private static ServiceFactoryImpl serviceFactory;

    public static ServiceFactoryImpl getInstance()throws Exception{
        if (serviceFactory==null){
            serviceFactory=new ServiceFactoryImpl();
        }
        return serviceFactory;
    }

    @Override
    public <T> T getSuperService(ServiceTypes serviceTypes) throws Exception {
        switch (serviceTypes){
            case CUSTOMER:
                return (T)new CustomerServiceImpl();
            case TICKET:
                return (T)new TicketServiceImpl();
            case SHEET:
                return (T)new SheetServiceImpl();
            case SHADULE:
                return (T)new ShaduleServiceImpl();
            case RESEPTION:
                return (T)new ReseptionServiceImpl();
            default:
                return null;

        }
    }
}
