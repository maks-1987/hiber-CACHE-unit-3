package org.hibernate;
import org.hibernate.dto.*;

import org.hibernate.cfg.Configuration;
import org.hibernate.dto.UserDetails;
import java.util.Date;

public class HibernateTest {
    public static void main(String[] args) {
        //final
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");

        TwoWheeler bike = new TwoWheeler();
        bike.setVehicleName("Bike");
        bike.setSteeringHandle("Bike Steering Handle");

        FourWheeler car = new FourWheeler();
        car.setVehicleName("Porsche");
        car.setSteeringWheel("Porsche Steering Wheel");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(vehicle);
        session.save(bike);
        session.save(car);

        session.getTransaction().commit();
        session.close();

    }
}
