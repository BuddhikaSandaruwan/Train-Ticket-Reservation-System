package lk.ijse.RmiFinal.Business.Custom;

import lk.ijse.RmiFinal.Business.SuperBusiness;
import lk.ijse.RmiFinal.DTO.CustomerDTO;
import lk.ijse.RmiFinal.DTO.SheetDTO;

import java.util.List;

public interface SheetBusiness  extends SuperBusiness {
    public boolean addSheet(SheetDTO dto)throws Exception;
    public boolean deleteSheet(SheetDTO dto)throws Exception;
    public boolean updateSheet(SheetDTO dto)throws Exception;
    public SheetDTO searchSheet(String id)throws Exception;
    public List<SheetDTO> getAllSheet()throws Exception;
}
