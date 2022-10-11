package com.RESTcarpassenger.RESTCarpassenger.service;

import com.RESTcarpassenger.RESTCarpassenger.JpaUtils.JpaEntityManagerFactoryProvider;
import com.RESTcarpassenger.RESTCarpassenger.entities.Car;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class CarServiceImpl implements CarService{
    EntityManagerFactory entityManagerFactory = JpaEntityManagerFactoryProvider.getEntityManagerFactoryObject();
    @Override
    public void addCar(Car car) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        System.out.println(car.getPassengerList());
//        entityManager.persist(car.getPassengerList());
        car.getPassengerList().stream().forEach(passenger -> entityManager.persist(passenger));
        entityManager.persist(car);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Car> getCarList() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        return entityManager.createQuery("from Car").getResultList();
    }

    @Override
    public void deleteCar(int carId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Car.class,carId));
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateCar(int carID) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entityManager.find(Car.class,carID));
        entityManager.getTransaction().commit();
    }
}
