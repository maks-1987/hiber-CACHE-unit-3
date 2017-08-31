package org.hibernate;
import org.hibernate.dto.*;

import org.hibernate.cfg.Configuration;
import org.hibernate.dto.UserDetails;
import java.util.Date;

public class HibernateTest {
    public static void main(String[] args) {
        //UserDetails user = new UserDetails();
        //user.setUserName("Test_User");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        UserDetails user = (UserDetails) session.get(UserDetails.class, 1);
        //session.save(user);
        //user.setUserName("Updated_User");
        //user.setUserName("Updated_User_Again");
        session.getTransaction().commit();
        session.close();

        user.setUserName("Change name");

        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        //user.setUserName("Change After Update");
        session.getTransaction().commit();
        session.close();

    }
}
