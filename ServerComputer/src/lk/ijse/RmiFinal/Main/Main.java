package lk.ijse.RmiFinal.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lk.ijse.RmiFinal.Entity.Admin;
import lk.ijse.RmiFinal.Service.Impl.ServiceFactoryImpl;
import lk.ijse.RmiFinal.Service.ServiceFactory;
import lk.ijse.RmiFinal.UTIL.PasswordUtil;
import lk.ijse.RmiFinal.Util.HibanateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.security.spec.InvalidKeySpecException;

public class Main{
    public static void main(String[] args) throws InvalidKeySpecException {
//        try (SessionFactory sessionFactory = HibanateUtil.getSessionFactory()) {
//            Session session = sessionFactory.openSession();
//            session.beginTransaction();
//
//            String nic = "972831379V";
//            String uName = "superadmin";
//            String pw = "superadmin";
//            String salt = PasswordUtil.getSalt(30);
//            String newPW = PasswordUtil.generateSecurePassword(pw, salt);
//            Admin admin = new Admin(nic, uName, newPW, salt);
//            session.save(admin);
//
//
//            session.getTransaction().commit();
//        }

//        =============================
        try {
            Registry registry= LocateRegistry.createRegistry(5050);
            registry.rebind("ijse", ServiceFactoryImpl.getInstance());
            System.out.println("Server Has been Started");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
