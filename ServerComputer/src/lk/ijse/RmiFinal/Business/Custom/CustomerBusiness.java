package lk.ijse.RmiFinal.Business.Custom;

import lk.ijse.RmiFinal.Business.SuperBusiness;
import lk.ijse.RmiFinal.DTO.CustomerDTO;

import java.util.List;

public interface CustomerBusiness extends SuperBusiness {
    public boolean addCustomer(CustomerDTO dto) throws Exception;

    public boolean deleteCustomer(CustomerDTO dto) throws Exception;

    public CustomerDTO searcCustomer(String id) throws Exception;

    public boolean updateCustomer(CustomerDTO dto) throws Exception;

    public List<CustomerDTO> getAllCustomers()throws Exception;
}
