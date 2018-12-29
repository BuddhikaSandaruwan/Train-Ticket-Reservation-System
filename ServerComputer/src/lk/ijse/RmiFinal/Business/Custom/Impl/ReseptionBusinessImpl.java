package lk.ijse.RmiFinal.Business.Custom.Impl;

import lk.ijse.RmiFinal.Business.Custom.ReseptionBusiness;
import lk.ijse.RmiFinal.DTO.ReseptionDTO;
import lk.ijse.RmiFinal.Entity.Reseption;
import lk.ijse.RmiFinal.Repository.Custom.ReseptionRepo;
import lk.ijse.RmiFinal.Repository.RepoFactory;
import lk.ijse.RmiFinal.Util.HibanateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ReseptionBusinessImpl implements ReseptionBusiness {

    public boolean add;
    public List<ReseptionDTO> reseptionDTOS;

    ReseptionRepo repository = RepoFactory.getInstance().getRepositoryFor(RepoFactory.RepoTypes.RESEPTION);


    @Override
    public boolean addReseption(ReseptionDTO dto) {

        try {
            Session openSession = HibanateUtil.getSessionFactory().openSession();
            repository.setSession(openSession);
            openSession.getTransaction().begin();
            Reseption reseption = new Reseption(dto.getrNIC(), dto.getuName(), dto.getPassword(), dto.getSalt());
            add = repository.add(reseption);
            openSession.getTransaction().commit();
            openSession.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return add;
    }

    @Override
    public boolean deleteReseption(ReseptionDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean updateReseption(ReseptionDTO dto) throws Exception {
        return false;
    }

    @Override
    public ReseptionDTO searchReseption(String id) throws Exception {
        return null;
    }

    @Override
    public List<ReseptionDTO> getAllReseption() throws Exception {
        Session openSession = HibanateUtil.getSessionFactory().openSession();
        repository.setSession(openSession);
        openSession.getTransaction().begin();
        List<Reseption> response = repository.getAll();
        List<ReseptionDTO>reseptionDTOS=new ArrayList<>();
        for (Reseption i:response){
            ReseptionDTO reseptionDTO=new ReseptionDTO(i.getrNIC(),i.getuName(),i.getPassword(),i.getSalt());
            reseptionDTOS.add(reseptionDTO);
        }
        openSession.getTransaction().commit();
        openSession.close();
        return reseptionDTOS;
    }
}
