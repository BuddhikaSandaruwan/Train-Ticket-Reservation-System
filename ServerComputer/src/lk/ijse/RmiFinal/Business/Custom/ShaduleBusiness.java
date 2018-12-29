package lk.ijse.RmiFinal.Business.Custom;

import lk.ijse.RmiFinal.Business.SuperBusiness;
import lk.ijse.RmiFinal.DTO.CustomerDTO;
import lk.ijse.RmiFinal.DTO.ShaduleDTO;

import java.util.List;

public interface ShaduleBusiness extends SuperBusiness {
    public boolean addShadule(ShaduleDTO dto)throws Exception;
    public boolean deleteShadule(ShaduleDTO dto)throws Exception;
    public boolean updateShadule(ShaduleDTO dto)throws Exception;
    public ShaduleDTO searchShadule(String id)throws Exception;
    public List<ShaduleDTO> getAllShadule()throws Exception;
}
