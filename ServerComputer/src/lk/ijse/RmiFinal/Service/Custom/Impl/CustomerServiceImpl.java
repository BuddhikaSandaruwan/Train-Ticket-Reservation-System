package lk.ijse.RmiFinal.Service.Custom.Impl;

import lk.ijse.RmiFinal.Business.BusinessFactory;
import lk.ijse.RmiFinal.Business.Custom.CustomerBusiness;
import lk.ijse.RmiFinal.DTO.CustomerDTO;
import lk.ijse.RmiFinal.Observer.Observer;
import lk.ijse.RmiFinal.Reservation.ReservationsImpl;
import lk.ijse.RmiFinal.Service.Custom.CustomerService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl extends UnicastRemoteObject implements CustomerService {

    CustomerBusiness businessFor= BusinessFactory.getInstance().getBusinessFor(BusinessFactory.BusinessTypes.CUSTOMER);
    private static ArrayList<Observer>allCustomerObservers=new ArrayList<>();
    private static ReservationsImpl<CustomerService>customerResavations=new ReservationsImpl<>();

    public CustomerServiceImpl() throws Exception {
    }

    @Override
    public boolean addCustomer(CustomerDTO dto) throws Exception {
        notifyAllObservers();
        return businessFor.addCustomer(dto);
    }

    @Override
    public boolean deleteCustomer(CustomerDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws Exception {
        return false;
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws Exception {
        return businessFor.searcCustomer(id);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() throws Exception {
        return null;
    }

    @Override
    public void register(Observer observer) throws Exception {

    }

    @Override
    public void unregister(Observer observer) throws Exception {

    }

    @Override
    public void notifyAllObservers() throws Exception {
        for (Observer observer:allCustomerObservers){
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
