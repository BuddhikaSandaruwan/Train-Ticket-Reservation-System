package lk.ijse.RmiFinal.Business.Custom.Impl;

import lk.ijse.RmiFinal.Business.Custom.CustomerBusiness;
import lk.ijse.RmiFinal.DTO.CustomerDTO;
import lk.ijse.RmiFinal.Entity.Customer;
import lk.ijse.RmiFinal.Repository.Custom.CustomerRepo;
import lk.ijse.RmiFinal.Repository.RepoFactory;
import lk.ijse.RmiFinal.Util.HibanateUtil;
import org.hibernate.Session;

import java.util.List;

public class CustomerBusinessImpl implements CustomerBusiness {

    CustomerRepo repositoryFor= RepoFactory.getInstance().getRepositoryFor(RepoFactory.RepoTypes.CUSTOMER);

    public CustomerBusinessImpl() {

    }

    @Override
    public boolean addCustomer(CustomerDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteCustomer(CustomerDTO dto) throws Exception {
        return false;
    }

    @Override
    public CustomerDTO searcCustomer(String id) throws Exception {
        Session openSession = HibanateUtil.getSessionFactory().openSession();
        repositoryFor.setSession(openSession);
        openSession.getTransaction().begin();
        Customer search = repositoryFor.search(id);
        CustomerDTO customerDTO=new CustomerDTO(search.getCusID(),search.getCusName(),search.getCusAdress(),search.getCusTP());
        openSession.getTransaction().commit();
        openSession.close();
        return customerDTO;
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws Exception {
        return false;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() throws Exception {
        return null;
    }
}
