package lk.ijse.RmiFinal.Service.Custom.Impl;

import lk.ijse.RmiFinal.Business.BusinessFactory;
import lk.ijse.RmiFinal.Business.Custom.TicketBusiness;
import lk.ijse.RmiFinal.DTO.BookingDTO;
import lk.ijse.RmiFinal.DTO.TicatDTO;
import lk.ijse.RmiFinal.Observer.Observer;
import lk.ijse.RmiFinal.Reservation.ReservationsImpl;
import lk.ijse.RmiFinal.Service.Custom.TicketService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class TicketServiceImpl extends UnicastRemoteObject implements TicketService {


    TicketBusiness businessFor= BusinessFactory.getInstance().getBusinessFor(BusinessFactory.BusinessTypes.TICKET);
    private static ArrayList<Observer> allShaduleObservers = new ArrayList<>();
    private static ReservationsImpl<TicketService> shaduleReservations = new ReservationsImpl<>();

    public TicketServiceImpl() throws Exception {
    }


    @Override
    public boolean addTicket(BookingDTO dto) throws Exception {
        notifyAllObservers();
        return businessFor.addTicket(dto);
    }

    @Override
    public boolean deleteTicket(TicatDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean updateTicket(TicatDTO dto) throws Exception {
        return false;
    }

    @Override
    public TicatDTO searchTicket(String id) throws Exception {
        return null;
    }

    @Override
    public List<TicatDTO> getAllTicket() throws Exception {
        return null;
    }

    @Override
    public void register(Observer observer) throws Exception {
        allShaduleObservers.add(observer);
    }

    @Override
    public void unregister(Observer observer) throws Exception {
        allShaduleObservers.remove(observer);
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
