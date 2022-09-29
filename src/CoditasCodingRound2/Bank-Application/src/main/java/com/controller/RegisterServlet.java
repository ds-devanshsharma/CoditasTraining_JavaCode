package com.controller;

import com.DAOBank.DAOBankOperation;
import com.DAOBank.DAOBankOperationImpl;
import com.accountNumberGenerator.RandomAccountNumberGenerator;
import com.bean.Address;
import com.bean.CurrentAccount;
import com.bean.SavingAccount;
import com.sun.media.sound.DLSInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    PrintWriter out ;
    SavingAccount savingAccount;
    CurrentAccount currentAccount;
    Address address;
    DAOBankOperation daoBankOperation = new DAOBankOperationImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        out = resp.getWriter();
        String accountType = req.getParameter("accountType");
        if(accountType.equalsIgnoreCase("savingAccount")){
            List<Address> list = takeInputFromRegisterForm(req,resp);
                savingAccount = new SavingAccount();
                savingAccount.setAccountNO(RandomAccountNumberGenerator.accountGenerator());
                savingAccount.setAccountHolderName(req.getParameter("holder"));
                savingAccount.setAddress(list);
                savingAccount.setContact(req.getParameter("contact"));
                //setting 10000 as welcome bonus
                savingAccount.setBalance(10000);
                if(daoBankOperation.registerSavingAccount(savingAccount)>0) {
                    out.println("<h3> Saving Account Added Successfully !!</h3>");
                    req.getRequestDispatcher("LoginPage.html").include(req,resp);
                }
                else{
                    out.println("<h3> Something Went Wrong !!</h3>");
                    req.getRequestDispatcher("RegisterAccount.html").include(req,resp);
                }
        }
        else{
            List<Address> list = takeInputFromRegisterForm(req,resp);
                currentAccount = new CurrentAccount();
            currentAccount.setAccountNO(RandomAccountNumberGenerator.accountGenerator());
            currentAccount.setAccountHolderName(req.getParameter("holder"));
            currentAccount.setAddress(list);
            currentAccount.setContact(req.getParameter("contact"));
            //setting 10000 as welcome bonus
            currentAccount.setBalance(10000);
            if(daoBankOperation.registerCurrentAccount(currentAccount)>0) {
                out.println("<h3> Current Account Added Successfully !!</h3>");
                req.getRequestDispatcher("LoginPage.html").include(req,resp);
            }
            else{
                out.println("<h3> Something Went Wrong !!</h3>");
                req.getRequestDispatcher("RegisterAccount.html").include(req,resp);
            }
        }
    }
    private List<Address> takeInputFromRegisterForm(HttpServletRequest req, HttpServletResponse resp) {
        List<Address> addresses = new ArrayList<>();
        address = new Address();
        address.setFlatNo(Integer.parseInt(req.getParameter("flat")));
        address.setCity(req.getParameter("city"));
        address.setPinCode(req.getParameter("pincode"));
        address.setStreet(req.getParameter("street"));
        addresses.add(address);
        if(req.getParameter("addressType").equalsIgnoreCase("sameAddress")){
            address.setFlatNo(Integer.parseInt(req.getParameter("flat")));
            address.setCity(req.getParameter("city"));
            address.setPinCode(req.getParameter("pincode"));
            address.setStreet(req.getParameter("street"));
            addresses.add(address);
        }
        else{
            address.setFlatNo(Integer.parseInt(req.getParameter("flat1")));
            address.setCity(req.getParameter("city1"));
            address.setPinCode(req.getParameter("pincode1"));
            address.setStreet(req.getParameter("street1"));
            addresses.add(address);
        }
        return addresses;
    }
}
