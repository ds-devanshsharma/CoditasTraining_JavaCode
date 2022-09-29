package com.controller;

import com.SessionFactoryProvider.SessionFactoryProvider;
import com.bean.CurrentAccount;
import com.bean.SavingAccount;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    PrintWriter out ;
    Session session;
    HttpSession httpSession ;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        out = resp.getWriter();
        long accountNumber = Long.parseLong(req.getParameter("userId"));
        String password = req.getParameter("password");
        session = SessionFactoryProvider.getSessionFactory().openSession();
        if(req.getParameter("accountType" ).equalsIgnoreCase("savingAccount")){

            SavingAccount savingAccountHolder = (SavingAccount) session.get(SavingAccount.class,accountNumber);
                    if(savingAccountHolder.getContact().equalsIgnoreCase(password)){
                        out.println("</h3>"
                                +savingAccountHolder.getAccountHolderName()+
                                "</h3>");
                        httpSession.setAttribute("user",savingAccountHolder);
                        req.getRequestDispatcher("displayServlet").include(req,resp);
                    }
                    else{
                        out.println("</h3>"
                                +"Incorrect Credential !"+
                                "</h3>");
                        req.getRequestDispatcher("LoginPage.html").include(req,resp);
                    }
        }else{
            CurrentAccount currentAccountHolder = (CurrentAccount)session.get(CurrentAccount.class,accountNumber);
                    if(currentAccountHolder.getContact().equalsIgnoreCase(password)){
                        out.println("</h3>"
                                +currentAccountHolder.getAccountHolderName()+
                                "</h3>");
                        httpSession.setAttribute("user",currentAccountHolder);
                        req.getRequestDispatcher("displayServlet").include(req,resp);
                    }
                    else{
                        out.println("</h3>"
                                +"Incorrect Credential !"+
                                "</h3>");
                        req.getRequestDispatcher("LoginPage.html").include(req,resp);
                    }
        }
    }
}
