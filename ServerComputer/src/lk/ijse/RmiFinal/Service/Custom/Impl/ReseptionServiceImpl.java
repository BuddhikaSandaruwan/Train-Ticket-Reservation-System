package lk.ijse.RmiFinal.Service.Custom.Impl;

import lk.ijse.RmiFinal.Business.BusinessFactory;
import lk.ijse.RmiFinal.Business.Custom.ReseptionBusiness;
import lk.ijse.RmiFinal.DTO.ReseptionDTO;
import lk.ijse.RmiFinal.Observer.Observer;
import lk.ijse.RmiFinal.Reservation.ReservationsImpl;
import lk.ijse.RmiFinal.Service.Custom.ReseptionService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ReseptionServiceImpl extends UnicastRemoteObject implements ReseptionService {

    public boolean b;

    ReseptionBusiness businessFor= BusinessFactory.getInstance().getBusinessFor(BusinessFactory.BusinessTypes.RESEPTION);
    private static ArrayList<Observer> allShaduleObservers = new ArrayList<>();
    private static ReservationsImpl<ReseptionService> shaduleReservations = new ReservationsImpl<>();

    public ReseptionServiceImpl()throws Exception {
    }

    @Override
    public boolean addReseption(ReseptionDTO dto){
        System.out.println(dto.getrNIC());
        System.out.println(dto.getuName());
        System.out.println(dto.getPassword());
        System.out.println(dto.getSalt());

        try {
            notifyAllObservers();
            b = businessFor.addReseption(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public boolean deleteReseption(ReseptionDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean updateReseption(ReseptionDTO dto) throws Exception {
        return false;
    }

    @Override
    public ReseptionDTO searchReseption(String id) throws Exception {
        return null;
    }

    @Override
    public List<ReseptionDTO> getAllReseption() throws Exception {
        return businessFor.getAllReseption();
    }

    @Override
    public void register(Observer observer) throws Exception {

    }

    @Override
    public void unregister(Observer observer) throws Exception {

    }

    @Override
    public void notifyAllObservers() throws Exception {

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
