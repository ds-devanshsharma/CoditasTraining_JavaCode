package com.DAO.StudentOperation;

import com.DAO.JDBC.CrudJDBC;
import com.DAO.JDBC.CrudJDBCImplementation;
import com.bean.Address;
import com.bean.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentOperationImplementation implements StudentOperationList{
    Address address ;
    Student student;
    CrudJDBC jdbc = new CrudJDBCImplementation();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int check;
    @Override
    public void insertStudent() throws IOException {
        address = new Address();
        System.out.println("Enter Flat No : ");address.setFlatNo(Integer.parseInt(reader.readLine()));
        System.out.println("Enter City : ");address.setCity(reader.readLine());
        System.out.println("Enter PinCode : ");address.setPincode(Integer.parseInt(reader.readLine()));
        //call address CrudInsertJDBCTemplate at the end
        student = new Student();
        System.out.println("Enter StudentID  :");student.setStudentID(Integer.parseInt(reader.readLine()));
        System.out.println("Enter FirstName : ");student.setFirstName(reader.readLine());
        System.out.println("Enter LastName : ");student.setLastName(reader.readLine());
        System.out.println("Enter Rating : ");student.setRating(Integer.parseInt(reader.readLine()));
        System.out.println("Enter BatchName : ");student.setBatch(reader.readLine());

        //calling jdbcInsert for  Address
        if(jdbc.insertAddress(address)==0) System.out.println("Error in inserting Address !!");
        //call student CrudInsertJDBCTemplate
        if(jdbc.insert(student)!=0) System.out.println("Record Added Successfully !!");
        else System.out.println("Error in Inserting Student");
    }

    @Override
    public void deleteStudent() {

    }

    @Override
    public void updateStudent() {

    }

    @Override
    public void fetchStudent() {

    }

    @Override
    public void fetchStudentBasedOnID() {

    }
}
