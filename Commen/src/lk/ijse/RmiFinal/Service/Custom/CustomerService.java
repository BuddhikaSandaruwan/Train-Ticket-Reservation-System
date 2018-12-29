package lk.ijse.RmiFinal.Service.Custom;

import lk.ijse.RmiFinal.DTO.CustomerDTO;
import lk.ijse.RmiFinal.Observer.Subject;
import lk.ijse.RmiFinal.Reservation.Reservations;
import lk.ijse.RmiFinal.Service.SuperService;

import java.util.List;

public interface CustomerService extends SuperService, Reservations, Subject {
    public boolean addCustomer(CustomerDTO dto)throws Exception;
    public boolean deleteCustomer(CustomerDTO dto)throws Exception;
    public boolean updateCustomer(CustomerDTO dto)throws Exception;
    public CustomerDTO searchCustomer(String id)throws Exception;
    public List<CustomerDTO> getAllCustomers()throws Exception;
}
