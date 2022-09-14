package Employee.Registration.controller;

import Employee.Registration.DAO.EmployeeDAO;
import Employee.Registration.model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
    public EmployeeServlet(){
        super();
    }
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Served At : ").append(req.getContextPath());
        req.getRequestDispatcher("EmployeeRegister.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName=req.getParameter("firstname");
        String lastName=req.getParameter("lastname");
        String userName=req.getParameter("username");
        String password=req.getParameter("password");
        String address=req.getParameter("address");
        int empID= Integer.parseInt(req.getParameter("id"));
        long contact= Long.parseLong(req.getParameter("contact"));
        Employee employee = new Employee();
        employee.setEmpID(empID);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAddress(address);
        employee.setContact(contact);
        employee.setUserName(userName);
        employee.setPassword(password);
        //resgistering into database
        if(employeeDAO.registerEmployee(employee)!=0)
            resp.sendRedirect("views/EmployeeDetails.jsp");
        else resp.sendRedirect("view/EmployeeRegister.jsp");
        // just keep it empty for now


    }
}
