package lk.ijse.RmiFinal.Business;

import lk.ijse.RmiFinal.Business.Custom.Impl.*;

public class BusinessFactory {
    private static BusinessFactory businessFactory;

    public static BusinessFactory getInstance(){
        if (businessFactory==null){
            businessFactory=new BusinessFactory();
        }
        return businessFactory;
    }

    public enum BusinessTypes{
        CUSTOMER,TICKET,SHADULE,SHEET,RESEPTION;
    }

    public <T>T getBusinessFor(BusinessTypes types){
        switch (types){
            case CUSTOMER:
                return (T) new CustomerBusinessImpl();
            case TICKET:
                return (T) new TicketBusinessImpl();
            case SHADULE:
                return (T) new ShaduleBusinessImpl();
            case SHEET:
                return (T) new SheetBusinessImpl();
            case RESEPTION:
                return (T) new ReseptionBusinessImpl();
            default:
                return null;
        }
    }

}
