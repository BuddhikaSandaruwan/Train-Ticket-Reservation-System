package lk.ijse.RmiFinal.Service.Custom;

import lk.ijse.RmiFinal.DTO.BookingDTO;
import lk.ijse.RmiFinal.DTO.CustomerDTO;
import lk.ijse.RmiFinal.DTO.TicatDTO;
import lk.ijse.RmiFinal.Observer.Subject;
import lk.ijse.RmiFinal.Reservation.Reservations;
import lk.ijse.RmiFinal.Service.SuperService;

import java.util.List;

public interface TicketService extends SuperService, Reservations, Subject {
    public boolean addTicket(BookingDTO dto)throws Exception;
    public boolean deleteTicket(TicatDTO dto)throws Exception;
    public boolean updateTicket(TicatDTO dto)throws Exception;
    public TicatDTO searchTicket(String id)throws Exception;
    public List<TicatDTO> getAllTicket()throws Exception;
}
