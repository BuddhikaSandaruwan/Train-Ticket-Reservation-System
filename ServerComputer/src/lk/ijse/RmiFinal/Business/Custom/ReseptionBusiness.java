package lk.ijse.RmiFinal.Business.Custom;

import lk.ijse.RmiFinal.Business.SuperBusiness;
import lk.ijse.RmiFinal.DTO.ReseptionDTO;

import java.util.List;

public interface ReseptionBusiness extends SuperBusiness {
    public boolean addReseption(ReseptionDTO dto)throws Exception;
    public boolean deleteReseption(ReseptionDTO dto)throws Exception;
    public boolean updateReseption(ReseptionDTO dto)throws Exception;
    public ReseptionDTO searchReseption(String id)throws Exception;
    public List<ReseptionDTO> getAllReseption()throws Exception;
}
