package lk.ijse.RmiFinal.Service.Custom;

import lk.ijse.RmiFinal.DTO.ShaduleDTO;
import lk.ijse.RmiFinal.Observer.Subject;
import lk.ijse.RmiFinal.Reservation.Reservations;
import lk.ijse.RmiFinal.Service.SuperService;

import java.util.List;

public interface ShaduleService extends SuperService, Reservations, Subject {
    public boolean addShadule(ShaduleDTO dto)throws Exception;
    public boolean deleteShadule(ShaduleDTO dto)throws Exception;
    public boolean updateShadule(ShaduleDTO dto)throws Exception;
    public ShaduleDTO searchShadule(String id)throws Exception;
    public List<ShaduleDTO> getAllShadule()throws Exception;
}

