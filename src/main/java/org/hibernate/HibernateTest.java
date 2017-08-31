package org.hibernate;
import org.hibernate.dto.*;

import org.hibernate.cfg.Configuration;
import org.hibernate.dto.UserDetails;
import java.util.Date;

public class HibernateTest {
    public static void main(String[] args) {

        UserDetails user = new UserDetails();
        user.setUserName("Test_User");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();


        session.save(user);
        user.setUserName("Updated_User");
        user.setUserName("Updated_User_Again");

        session.getTransaction().commit();
        session.close();

        user.setUserName("Updated_User_After_Close");
    }
}
