package org.hibernate;
import org.hibernate.dto.*;

import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.dto.UserDetails;

public class HibernateTest {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        /*for (int i=0; i<10; i++){
            UserDetails user = new UserDetails();
            user.setUserName("User " + i);
            session.save(user);
        }*/
        Query query = session.createQuery("from UserDetails were userId > 5");
        List users = query.list();
        session.getTransaction().commit();
        session.close();
        System.out.println("Size of list result = " + users.size());

    }
}
