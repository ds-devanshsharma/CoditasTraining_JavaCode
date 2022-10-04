package com.service;

import com.HibernateUtils.SessionFactoryProvider;
import com.entities.Shop;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService{
    @Autowired
    SessionFactory sessionFactory ;
    @Override
    public void addShop(Shop shop) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(shop);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Shop> showShopList() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session.createQuery("from Shop ").list();
    }

    @Override
    public void deleteShop(int shopID) {

    }

    @Override
    public void updateShop(int shopID) {

    }
}
