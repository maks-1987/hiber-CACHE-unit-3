package org.hibernate;
import org.hibernate.dto.*;

import org.hibernate.cfg.Configuration;
import org.hibernate.dto.UserDetails;
import java.util.Date;

public class HibernateTest {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.getTransaction().commit();
        session.close();

    }
}
