package com.main;

import com.bean.Answer;
import com.bean.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApplication {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        try(SessionFactory sessionFactory =   configuration.buildSessionFactory()){
//            //creatung Question
//            Question question = new Question();
//            question.setQuesID(10);
//            question.setQues("What is Collection ?");
//            Answer answer = new Answer();
//            answer.setAnsID(10);
//            answer.setAns("Collection is Java Framework .");
//            question.setAnswer(answer);
//
//            //
//            Question question1 = new Question();
//            question1.setQuesID(11);
//            question1.setQues("What is Java ?");
//            Answer answer1 = new Answer();
//            answer1.setAnsID(11);
//            answer1.setAns("Java is programming Language .");
//            question1.setAnswer(answer1);
//
//            Session session = sessionFactory.openSession();
//            Transaction transaction = session.beginTransaction();
//             session.save(answer);
//             session.save(answer1);
//            session.save(question);
//            session.save(question1);
            //fetching
            Session session = sessionFactory.openSession();
            Question question = session.get(Question.class,10);
            System.out.println(question);
//                transaction.commit();
//                System.out.println("RECORD ADDED SUCCESSFULLY !!");



        }

    }
}
