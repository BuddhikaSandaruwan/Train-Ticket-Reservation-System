package lk.ijse.RmiFinal.Repository;

import lk.ijse.RmiFinal.Repository.Custom.Impl.*;

public class RepoFactory {
    public static RepoFactory repoFactory;

    public static RepoFactory getInstance(){
        if (repoFactory==null){
            repoFactory=new RepoFactory();
        }
        return repoFactory;
    }
    public enum RepoTypes{
        CUSTOMER,TICKET,SHADULE,SHEET,RESEPTION;
    }
    public <T>T getRepositoryFor(RepoTypes repoTypes){
        switch (repoTypes){
            case CUSTOMER:
                return (T)new CustomerRepoImpl();
            case TICKET:
                return (T)new TicketRepoImpl();
            case SHADULE:
                return (T)new ShaduleRepoImpl();
            case SHEET:
                return (T)new SheetRepoImpl();
            case RESEPTION:
                return (T)new ReseptionRepoImpl();
            default:
                return null;
        }
    }
}
