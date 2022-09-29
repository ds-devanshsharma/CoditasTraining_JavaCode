package com.DAO;

import com.bean.Book;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;


public class BookCRUDImplementation implements BookCRUD {
    Transaction transaction;
    Book book;
    int check;
    Query query;
    @Override
    public void insertBook(Book book) {
        Session session = SessionFactoryProvider.getSessionFactoryProvider().openSession();
        transaction = session.beginTransaction();
        check=(int)  session.save(book);
        if(check!=0){
            transaction.commit();
            System.out.println("RECORD ADDED SUCCESSFULLY !!");
        }
    }
    @Override
    public void fetchBook() {
        Session session = SessionFactoryProvider.getSessionFactoryProvider().openSession();
//        transaction = session.beginTransaction();
//        session.createQuery("from Book ").list().stream().forEach(System.out::println);
        Criteria criteria = session.createCriteria(Book.class);
        criteria.list().stream().forEach(System.out::println);
    }
    @Override
    public void fetchBookByID(int id) {
        Session session = SessionFactoryProvider.getSessionFactoryProvider().openSession();
        transaction = session.beginTransaction();
//        query = session.createQuery("from Book where bookID =:i");
//        query.setParameter("i",id);
//        query.list().stream().forEach(System.out::println);

        // way->2 using session.get(Classname.class,int id)/session.load(classname.class,int id)
        book = session.get(Book.class,id);
        System.out.println(book);

        //way-> using session.byId(classname.class).getReference(int id);
        book = session.byId(Book.class).getReference(id);
        System.out.println(book);
    }
    @Override
    public void deleteBook(int id ) {
        Session session = SessionFactoryProvider.getSessionFactoryProvider().openSession();
        transaction = session.beginTransaction();
        query = session.createQuery("DELETE Book WHERE bookID =:X");
        query.setParameter("X",id);
        check = query.executeUpdate();
        if(check!=0){
            System.out.println("RECORD DELETED SUCCESSFULLY !");
        }
    }
    @Override
    public void updateBook(int id,float price) {

        Session session = SessionFactoryProvider.getSessionFactoryProvider().openSession();
        transaction = session.beginTransaction();
        query = session.createQuery("UPDATE Book SET price=:p where bookID=:i");

        query.setParameter("p",price);
        query.setParameter("i",id);
        check = query.executeUpdate();
        if(check!=0){
            System.out.println("RECORD UPDATED SUCCESSFULLY !!");
        }
        else{
            System.out.println("TRY AGAIN !!");
        }
    }

    @Override
    public void fetchByRestriction(float p) {
        Session session = SessionFactoryProvider.getSessionFactoryProvider().openSession();
        Criteria criteria = session.createCriteria(Book.class);
        criteria.add(Restrictions.gt("price",p));
        System.out.println(criteria.list());
    }

    @Override
    public void fetchByOrder(String order ,String property) {
        Session  session = SessionFactoryProvider.getSessionFactoryProvider().openSession();
        Criteria criteria = session.createCriteria(Book.class);
        if(order.equalsIgnoreCase("asc")){
            criteria.addOrder(Order.asc(property));
        }
        else{
            criteria.addOrder(Order.desc(property));
        }
        System.out.println(criteria.list());
    }

    @Override
    public void fetchByProjection(String property) {
        Session session = SessionFactoryProvider.getSessionFactoryProvider().openSession();
        Criteria criteria = session.createCriteria(Book.class);
        criteria.setProjection(Projections.property(property));
        criteria.list().stream().forEach(System.out::println);
    }
}
