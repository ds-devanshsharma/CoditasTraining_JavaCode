package com.DAO;

import com.bean.Address;
import com.bean.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CRUDOperationImplemention implements CRUDOperation{
    Student student;
    Address address;
    List<Address> addressList=null;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Transaction transaction ;
    @Override
    public void insertData() throws IOException {
        //
        dataInput();
        Session session = SessionFactoryProvider.getSessionFactoryProvider().openSession();
        transaction = session.beginTransaction();
        for(Address address1 : addressList)
                session.save(address1);

        int check = (int)session.save(student);
        if(check>0){
            transaction.commit();
            System.out.println("RECORD ADDED SUCCESSFULLY !!");
        }
    }
    public void dataInput() throws IOException {
        student = new Student();

        int flag =1;
        System.out.println("ENTER ID : ");student.setId(Integer.parseInt(reader.readLine()));
        System.out.println("ENTER NAME :");student.setName(reader.readLine());
        System.out.println("ENTER RATING :" );student.setRating(Float.parseFloat(reader.readLine()));
        System.out.println("ENTER BATCH : ");student.setBatch(reader.readLine());

        addressList =new ArrayList<>();

        do {
            address = new Address();
            System.out.println("ENTER FLAT NO : ");
            address.setFlatNo(Integer.parseInt(reader.readLine()));
            System.out.println("ENTER CITY : ");
            address.setCity(reader.readLine());
            System.out.println("ENTER PINCODE : ");
            address.setPincode(Integer.parseInt(reader.readLine()));
            address.setStudent(student);
            System.out.println("MORE ADDRESS ! ENTER 1 FOR YES \n" +
                    "ENTER 0 FOR NO ");
            flag = Integer.parseInt(reader.readLine());
            addressList.add(address);
        }while(flag != 0);
        student.setAddress(addressList);
    }

    @Override
    public void fetchData() {
        Session session = SessionFactoryProvider.getSessionFactoryProvider().openSession();
        session.beginTransaction();
    }

    @Override
    public void

    deleteData() throws IOException {
        Session session = SessionFactoryProvider.getSessionFactoryProvider().openSession();
        transaction  = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM STUDENT WHERE id =:I");
        System.out.println("ENTER ID FOR DELETE : ");
        query.setParameter("I",Integer.parseInt(reader.readLine()));
        int check = query.executeUpdate();
        if(check!=0){
            transaction.commit();
            System.out.println("RECORD DELETED SUCCESSFULLY !! ");
        }
        else{
            System.out.println("RECORD NOT FOUND !");
        }
    }

    @Override
    public void updateData() {

    }
}
