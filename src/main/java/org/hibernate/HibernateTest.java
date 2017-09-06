package org.hibernate;
import org.hibernate.criterion.*;
import org.hibernate.dto.*;

import java.util.List;
import org.hibernate.*;
import org.hibernate.Criteria;
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
        //String minUserId = "5";
        //Query query = session.getNamedQuery("UserDetails.byName"); //where userId > 5
        UserDetails exampleUser = new UserDetails();
        //exampleUser.setUserId(5);
        exampleUser.setUserName("User 1%");

        Example example = Example.create(exampleUser).enableLike();//.excludeProperty("userName");

        Criteria criteria = session.createCriteria(UserDetails.class)
                                   .add(example);
                            //.setProjection(Projections.property("userId"));
                            //.addOrder(Order.desc("userId"));

        //criteria.add(Restrictions.or(Restrictions.between("userId", 0, 3), (Restrictions.between("userId", 7, 10)));
                //Restrictions.like("userName", "%User 1%"))
                //.add(Restrictions.between("userId", 5, 50));
        //query.setString(0, "User 10");
        //query.setInteger(0, Integer.parseInt(minUserId));
        //query.setFirstResult(5);
        //query.setMaxResults(4);
        List<UserDetails> users = (List<UserDetails>) criteria.list();
        session.getTransaction().commit();
        session.close();

        for (UserDetails user : users)
            System.out.println(users);

    }
}
