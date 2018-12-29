package lk.ijse.RmiFinal.Business.Custom;

import lk.ijse.RmiFinal.Business.SuperBusiness;
import lk.ijse.RmiFinal.DTO.BookingDTO;
import lk.ijse.RmiFinal.DTO.CustomerDTO;
import lk.ijse.RmiFinal.DTO.TicatDTO;

import java.util.List;

public interface TicketBusiness extends SuperBusiness {
    public boolean addTicket(BookingDTO dto)throws Exception;
    public boolean deleteTicket(TicatDTO dto)throws Exception;
    public boolean updateTicket(TicatDTO dto)throws Exception;
    public TicatDTO searchTicket(String id)throws Exception;
    public List<TicatDTO> getAllTicket()throws Exception;
}
