package lk.ijse.RmiFinal.Util;

import lk.ijse.RmiFinal.Entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibanateUtil {
    public static SessionFactory sf=buildSessionFactory();
    private static SessionFactory buildSessionFactory(){
        StandardServiceRegistry registry=new StandardServiceRegistryBuilder().loadProperties("lk/ijse/RmiFinal/resorses.properties").build();
        Metadata metadata=new MetadataSources(registry)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Ticket.class)
                .addAnnotatedClass(Shadule.class)
                .addAnnotatedClass(Sheet.class)
                .addAnnotatedClass(Reseption.class)
                .addAnnotatedClass(Admin.class)
                .buildMetadata();
        return metadata.getSessionFactoryBuilder().build();
    }
    public static SessionFactory getSessionFactory(){
        return sf;
    }
}
