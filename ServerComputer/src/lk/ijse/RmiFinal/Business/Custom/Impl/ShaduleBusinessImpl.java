package lk.ijse.RmiFinal.Business.Custom.Impl;

import lk.ijse.RmiFinal.Business.Custom.ShaduleBusiness;
import lk.ijse.RmiFinal.DTO.ShaduleDTO;
import lk.ijse.RmiFinal.Entity.Shadule;
import lk.ijse.RmiFinal.Repository.Custom.ShaduleRepo;
import lk.ijse.RmiFinal.Repository.RepoFactory;
import lk.ijse.RmiFinal.Util.HibanateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ShaduleBusinessImpl implements ShaduleBusiness {

    ShaduleRepo shaduleRepo= RepoFactory.getInstance().getRepositoryFor(RepoFactory.RepoTypes.SHADULE);

    public ShaduleBusinessImpl() {
    }

    @Override
    public boolean addShadule(ShaduleDTO dto) throws Exception {
        Session openSession = HibanateUtil.getSessionFactory().openSession();
        shaduleRepo.setSession(openSession);
        openSession.getTransaction().begin();
        Shadule shadule=new Shadule(dto.getShaID(),dto.getName(),dto.getArival(),dto.getDeputure(),dto.getStartStation(),dto.getEndStation(),dto.getDate(),dto.getPrice());
        boolean response = shaduleRepo.add(shadule);
        openSession.getTransaction().commit();
        openSession.close();
        return response;
    }

    @Override
    public boolean deleteShadule(ShaduleDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean updateShadule(ShaduleDTO dto) throws Exception {
        return false;
    }

    @Override
    public ShaduleDTO searchShadule(String id) throws Exception {
        return null;
    }

    @Override
    public List<ShaduleDTO> getAllShadule() throws Exception {
        Session openSession = HibanateUtil.getSessionFactory().openSession();
        shaduleRepo.setSession(openSession);
        openSession.getTransaction().begin();
        List<Shadule> response = shaduleRepo.getAll();
        List<ShaduleDTO>shaduleDTOS=new ArrayList<>();
        for (Shadule i:response){
            ShaduleDTO shaduleDTO=new ShaduleDTO(i.getShaID(),i.getDay(),i.getStartStation(),i.getEndStation(),i.getTrainName(),i.getStartTime(),i.getEndTime(),i.getPrice());
            shaduleDTOS.add(shaduleDTO);
        }
        openSession.getTransaction().commit();
        openSession.close();
        return shaduleDTOS;
    }
}
