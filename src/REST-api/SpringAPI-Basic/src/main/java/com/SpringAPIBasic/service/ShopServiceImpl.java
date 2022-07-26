package com.SpringAPIBasic.service;

import com.SpringAPIBasic.HibernateUtils.SessionFactoryProvider;
import com.SpringAPIBasic.entities.Shop;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService{
//    @Autowired
//    SessionFactory sessionFactory;
    @Override
    public void addShop(Shop shop) {
        Session session = SessionFactoryProvider.sessionFactoryProviderMethod().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(shop);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Shop> showShopList() {
        Session session = SessionFactoryProvider.sessionFactoryProviderMethod().openSession();
        return session.createQuery("from Shop").list();
    }

    @Override
    public void deleteShop(int shopID) {

    }

    @Override
    public void updateShop(int shopID) {

    }
}
