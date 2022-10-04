package com.SpringAPIPractice.service;

import com.SpringAPIPractice.Entities.Car;
import com.SpringAPIPractice.util.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceImpl implements ServiceDAO{
    @Override
    public void insertCar(Car car) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.save(car);
        session.getTransaction().commit();
    }

    @Override
    public List<Car> fetchCar() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        return session.createQuery("From Car").list();
    }
}
