package lk.ijse.RmiFinal.Ploxy;

import lk.ijse.RmiFinal.Service.Custom.*;
import lk.ijse.RmiFinal.Service.ServiceFactory;

import java.rmi.Naming;

public class PloxyHandeler implements ServiceFactory {

    private static PloxyHandeler ploxyHandeler;
    private CustomerService customerService;
    private TicketService ticketService;
    private SheetService sheetService;
    private ShaduleService shaduleService;
    private ReseptionService reseptionService;

    public static PloxyHandeler getInstance()throws Exception{
        if (ploxyHandeler==null){
            ploxyHandeler=new PloxyHandeler();
        }
        return ploxyHandeler;
    }

    public PloxyHandeler()throws Exception{
        try {
            ServiceFactory serviceFactory=(ServiceFactory) Naming.lookup("rmi://localhost:5050/ijse");
            customerService=serviceFactory.getSuperService(ServiceFactory.ServiceTypes.CUSTOMER);
            ticketService=serviceFactory.getSuperService(ServiceFactory.ServiceTypes.TICKET);
            sheetService=serviceFactory.getSuperService(ServiceFactory.ServiceTypes.SHEET);
            shaduleService=serviceFactory.getSuperService(ServiceFactory.ServiceTypes.SHADULE);
            reseptionService=serviceFactory.getSuperService(ServiceTypes.RESEPTION);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public <T> T getSuperService(ServiceTypes serviceTypes) throws Exception {
        switch (serviceTypes){
            case CUSTOMER:
                return (T)customerService;
            case TICKET:
                return (T)ticketService;
            case SHEET:
                return (T)sheetService;
            case SHADULE:
                return (T)shaduleService;
            case RESEPTION:
                return (T)reseptionService;
            default:
                return null;
        }
    }
}
