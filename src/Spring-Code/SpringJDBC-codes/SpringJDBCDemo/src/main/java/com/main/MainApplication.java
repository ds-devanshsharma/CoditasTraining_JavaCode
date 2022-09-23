package com.main;

import com.DAO.BookDAOImplementaion;
import com.bean.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApplication {
    Book book ;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static  void menu(BookDAOImplementaion bookDAOImplementaion) throws IOException {
        System.out.println("ENTER 1 FOR INSERT !\n" +
                "ENTER 2 FOR DELETE !\n" +
                "ENTER 3 FOR FECTH ALL RECORDS !\n" +
                "ENTER 4 FOR UPDATE !\n" +
                "ENTER 5 FOR SPECIFIC BOOK RECORD !\n" +
                "Enter 0 for Exit !");
        switch (Integer.parseInt(reader.readLine())){
            case 1 :
                if(bookDAOImplementaion.insertBook()!=0) System.out.println("Record Added Successfully !");
                else System.out.println("SOMETHING WENT WRONG !!");
                break;
            case 2 :
                if(bookDAOImplementaion.deleteBook()!=0) System.out.println("RECORD DELETED SUCCESSFULLY !!");
                else System.out.println("RECORD NOT FOUND !!");
                break;
            case 3 :
                System.out.println(" -- BOOK RECORD -- ");
                bookDAOImplementaion.fetchAll();
                break;
            case 4 :
                System.out.println("-- UPDATE WIZARD --");
                if(bookDAOImplementaion.updateBook()!=0) System.out.println("RECORD UPDATED SUCCESSFULLY !!");;
                break;
            case 5:
                System.out.println(" -- BOOK RECORD -- ");
                bookDAOImplementaion.fetchSpecificBook();
                break;
            case 0:
                System.out.println("Logged Out");
                System.exit(0);
        }
    }

    public static void main(String[] args) throws IOException {

        ApplicationContext context =new ClassPathXmlApplicationContext("SpringJDBC.xml");
        BookDAOImplementaion bookDAOImplementaion =(BookDAOImplementaion) context.getBean("Implementation");

        while(true){
            menu(bookDAOImplementaion);
        }
    }
}
