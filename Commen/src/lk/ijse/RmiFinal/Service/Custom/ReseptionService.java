package lk.ijse.RmiFinal.Service.Custom;



import lk.ijse.RmiFinal.DTO.ReseptionDTO;
import lk.ijse.RmiFinal.Observer.Subject;
import lk.ijse.RmiFinal.Reservation.Reservations;
import lk.ijse.RmiFinal.Service.SuperService;

import java.util.List;

public interface ReseptionService extends SuperService, Reservations, Subject {
    public boolean addReseption(ReseptionDTO dto)throws Exception;
    public boolean deleteReseption(ReseptionDTO dto)throws Exception;
    public boolean updateReseption(ReseptionDTO dto)throws Exception;
    public ReseptionDTO searchReseption(String id)throws Exception;
    public List<ReseptionDTO> getAllReseption()throws Exception;
}
