package lk.ijse.RmiFinal.Business.Custom.Impl;

import lk.ijse.RmiFinal.Business.Custom.SheetBusiness;
import lk.ijse.RmiFinal.DTO.SheetDTO;
import lk.ijse.RmiFinal.Entity.Shadule;
import lk.ijse.RmiFinal.Entity.Sheet;
import lk.ijse.RmiFinal.Repository.Custom.SheetRepo;
import lk.ijse.RmiFinal.Repository.RepoFactory;
import lk.ijse.RmiFinal.Util.HibanateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class SheetBusinessImpl implements SheetBusiness {

    SheetRepo sheetRepo= RepoFactory.getInstance().getRepositoryFor(RepoFactory.RepoTypes.SHEET);

    public SheetBusinessImpl() {
    }

    @Override
    public boolean addSheet(SheetDTO dto) throws Exception {
        Session openSession = HibanateUtil.getSessionFactory().openSession();
        sheetRepo.setSession(openSession);
        openSession.getTransaction().begin();
        Shadule shadule = openSession.get(Shadule.class, dto.getShaID());
        Shadule shadule1=new Shadule(dto.getShaID());
        Sheet sheet=new Sheet(0,dto.getSheetID(),shadule,dto.getState());
        boolean response = sheetRepo.add(sheet);
        openSession.getTransaction().commit();
        openSession.close();
        return response;
    }

    @Override
    public boolean deleteSheet(SheetDTO dto) throws Exception {
        Session openSession = HibanateUtil.getSessionFactory().openSession();
        sheetRepo.setSession(openSession);
        openSession.getTransaction().begin();
        Shadule shadule = openSession.get(Shadule.class, dto.getShaID());
        Shadule shadule1=new Shadule(dto.getShaID());
        Sheet sheet=new Sheet(0,dto.getSheetID(),shadule,"booked");
        boolean response = sheetRepo.add(sheet);
        openSession.getTransaction().commit();
        openSession.close();
        return response;
    }

    @Override
    public boolean updateSheet(SheetDTO dto) throws Exception {
        return false;
    }

    @Override
    public SheetDTO searchSheet(String id) throws Exception {
        return null;
    }

    @Override
    public List<SheetDTO> getAllSheet() throws Exception {
        Session openSession = HibanateUtil.getSessionFactory().openSession();
        sheetRepo.setSession(openSession);
        openSession.getTransaction().begin();
        List<Sheet> response = sheetRepo.getAll();
        List<SheetDTO>shaduleDTOS=new ArrayList<>();
        for (Sheet i:response){
            Shadule shaID = i.getShaID();
            SheetDTO sheetDTO=new SheetDTO(i.getSheetID(),i.getState(),shaID.getShaID());
            shaduleDTOS.add(sheetDTO);
        }
        openSession.getTransaction().commit();
        openSession.close();
        return shaduleDTOS;
    }
}
