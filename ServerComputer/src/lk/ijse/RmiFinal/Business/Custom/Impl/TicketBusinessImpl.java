package lk.ijse.RmiFinal.Business.Custom.Impl;

import lk.ijse.RmiFinal.Business.Custom.TicketBusiness;
import lk.ijse.RmiFinal.DTO.BookingDTO;
import lk.ijse.RmiFinal.DTO.CustomerDTO;
import lk.ijse.RmiFinal.DTO.StaticDTO;
import lk.ijse.RmiFinal.DTO.TicatDTO;
import lk.ijse.RmiFinal.Entity.Customer;
import lk.ijse.RmiFinal.Entity.Shadule;
import lk.ijse.RmiFinal.Entity.Sheet;
import lk.ijse.RmiFinal.Entity.Ticket;
import lk.ijse.RmiFinal.Repository.Custom.CustomerRepo;
import lk.ijse.RmiFinal.Repository.Custom.ShaduleRepo;
import lk.ijse.RmiFinal.Repository.Custom.SheetRepo;
import lk.ijse.RmiFinal.Repository.Custom.TicketRepo;
import lk.ijse.RmiFinal.Repository.RepoFactory;
import lk.ijse.RmiFinal.Util.HibanateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class TicketBusinessImpl implements TicketBusiness {

    TicketRepo ticketRepo = RepoFactory.getInstance().getRepositoryFor(RepoFactory.RepoTypes.TICKET);
    CustomerRepo customerRepo = RepoFactory.getInstance().getRepositoryFor(RepoFactory.RepoTypes.CUSTOMER);
    SheetRepo sheetRepo = RepoFactory.getInstance().getRepositoryFor(RepoFactory.RepoTypes.SHEET);
    ShaduleRepo shaduleRepo = RepoFactory.getInstance().getRepositoryFor(RepoFactory.RepoTypes.SHADULE);


    public TicketBusinessImpl() {
    }


    @Override
    public boolean addTicket(BookingDTO dto) throws Exception {
        boolean add = false;
        CustomerDTO customerDTO = dto.getCustomerDTO();
        TicatDTO ticatDTO = dto.getTicatDTO();
        boolean add1 = false;

        Session openSession = HibanateUtil.getSessionFactory().openSession();
        ticketRepo.setSession(openSession);
        customerRepo.setSession(openSession);
        shaduleRepo.setSession(openSession);
        openSession.getTransaction().begin();
        System.out.println("======="+dto.getNewId());
        Customer search = openSession.get(Customer.class, customerDTO.getCusID());
        if (search == null) {
            Customer customer = new Customer(customerDTO.getCusID(), customerDTO.getCusName(), customerDTO.getCusAdress(), customerDTO.getCusTP());
            openSession.save(customer);
//            Shadule shad = shaduleRepo.search(dto.getNewId());
//            Shadule shadule = openSession.get(Shadule.class, dto.getNewId());
            Shadule shadule1=new Shadule(1,"rt","rtr","12","rtr","rtr",new Date(),122);
            Ticket ticket = new Ticket(ticatDTO.getTicID(), shadule1, ticatDTO.getPayment(), ticatDTO.getDate(), customer, ticatDTO.getSheetID());
            openSession.save(ticket);
            String sql = " UPDATE Sheet SET state='Bokked'" + " where sheetID= '" + ticatDTO.getSheetID() + "' ";
            Query query = openSession.createSQLQuery(sql);
            query.executeUpdate();
        }else {
            System.out.println( StaticDTO.getIds());
            Shadule shadule = openSession.get(Shadule.class, StaticDTO.getIds());
            Ticket ticket = new Ticket(ticatDTO.getTicID(), shadule, ticatDTO.getPayment(), ticatDTO.getDate(), search, ticatDTO.getSheetID());
            openSession.save(ticket);
            String sql = " UPDATE Sheet SET state='Bokked'" + " where sheetID= '" + ticatDTO.getSheetID() + "' ";
            Query query = openSession.createSQLQuery(sql);
            query.executeUpdate();
        }
//                Sheet sheet = openSession.get(Sheet.class, ticatDTO.getSheetID());
//                Sheet newSheet1=new Sheet(sheet.getSheetID(),sheet.getShaID(),"Booked");
                /*System.out.println(sheet.getSheetID());
                System.out.println(sheet.getShaID());*/
//                sheetRepo.update(sheet);


        openSession.getTransaction().commit();
        openSession.close();
        return true;


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
}
