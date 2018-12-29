package lk.ijse.RmiFinal.Service.Custom.Impl;

import lk.ijse.RmiFinal.Business.BusinessFactory;
import lk.ijse.RmiFinal.Business.Custom.ShaduleBusiness;
import lk.ijse.RmiFinal.DTO.ShaduleDTO;
import lk.ijse.RmiFinal.Observer.Observer;
import lk.ijse.RmiFinal.Reservation.ReservationsImpl;
import lk.ijse.RmiFinal.Service.Custom.ShaduleService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ShaduleServiceImpl extends UnicastRemoteObject implements ShaduleService {

    ShaduleBusiness businessFor= BusinessFactory.getInstance().getBusinessFor(BusinessFactory.BusinessTypes.SHADULE);
    private static ArrayList<Observer> allShaduleObservers = new ArrayList<>();
    private static ReservationsImpl<ShaduleService> shaduleReservations = new ReservationsImpl<>();



    public ShaduleServiceImpl() throws Exception {
    }

    @Override
    public boolean addShadule(ShaduleDTO dto) throws Exception {
        notifyAllObservers();
        return businessFor.addShadule(dto);
    }

    @Override
    public boolean deleteShadule(ShaduleDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean updateShadule(ShaduleDTO dto) throws Exception {
        return false;
    }

    @Override
    public ShaduleDTO searchShadule(String id) throws Exception {
        return null;
    }

    @Override
    public List<ShaduleDTO> getAllShadule() throws Exception {
       return businessFor.getAllShadule();
    }

    @Override
    public void register(Observer observer) throws Exception {

    }

    @Override
    public void unregister(Observer observer) throws Exception {

    }

    @Override
    public void notifyAllObservers() throws Exception {
        for (Observer observer:allShaduleObservers){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        observer.update();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    @Override
    public boolean reserved(Object id) throws Exception {
        return false;
    }

    @Override
    public boolean released(Object id) throws Exception {
        return false;
    }
}
