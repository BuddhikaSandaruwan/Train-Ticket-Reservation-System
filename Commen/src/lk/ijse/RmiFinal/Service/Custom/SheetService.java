package lk.ijse.RmiFinal.Service.Custom;

import lk.ijse.RmiFinal.DTO.CustomerDTO;
import lk.ijse.RmiFinal.DTO.SheetDTO;
import lk.ijse.RmiFinal.Observer.Subject;
import lk.ijse.RmiFinal.Reservation.Reservations;
import lk.ijse.RmiFinal.Service.SuperService;

import java.util.List;

public interface SheetService extends SuperService, Reservations, Subject {
    public boolean addSheet(SheetDTO dto)throws Exception;
    public boolean deleteSheet(SheetDTO dto)throws Exception;
    public boolean updateSheet(SheetDTO dto)throws Exception;
    public SheetDTO searchSheet(String id)throws Exception;
    public List<SheetDTO> getAllSheet()throws Exception;
}
