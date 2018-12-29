package lk.ijse.RmiFinal.Service.Custom.Impl;

import lk.ijse.RmiFinal.Business.BusinessFactory;
import lk.ijse.RmiFinal.Business.Custom.SheetBusiness;
import lk.ijse.RmiFinal.DTO.SheetDTO;
import lk.ijse.RmiFinal.Observer.Observer;
import lk.ijse.RmiFinal.Reservation.ReservationsImpl;
import lk.ijse.RmiFinal.Service.Custom.CustomerService;
import lk.ijse.RmiFinal.Service.Custom.SheetService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class SheetServiceImpl extends UnicastRemoteObject implements SheetService {

    SheetBusiness sheetBusiness= BusinessFactory.getInstance().getBusinessFor(BusinessFactory.BusinessTypes.SHEET);
    private static ArrayList<Observer> allSheetObservers = new ArrayList<>();
    private static ReservationsImpl<SheetService> sheetReservations = new ReservationsImpl<>();



    public SheetServiceImpl() throws Exception {
    }

    @Override
    public boolean addSheet(SheetDTO dto) throws Exception {
        notifyAllObservers();
        return sheetBusiness.addSheet(dto);
    }

    @Override
    public boolean deleteSheet(SheetDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean updateSheet(SheetDTO dto) throws Exception {
        return sheetBusiness.updateSheet(dto);
    }

    @Override
    public SheetDTO searchSheet(String id) throws Exception {
        return null;
    }

    @Override
    public List<SheetDTO> getAllSheet() throws Exception {
        return sheetBusiness.getAllSheet();
    }

    @Override
    public void register(Observer observer) throws Exception {
        allSheetObservers.add(observer);
    }

    @Override
    public void unregister(Observer observer) throws Exception {
        allSheetObservers.remove(observer);
    }

    @Override
    public void notifyAllObservers() throws Exception {
        for (Observer observer:allSheetObservers){
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
