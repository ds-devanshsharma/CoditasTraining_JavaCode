package com.DAO;

import com.bean.Address;
import com.bean.Employee;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DAOImplementation implements EmployeeDAO{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Address address;
    Employee employee;
    int check;
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertData() throws IOException {
        address = new Address();
        employee= new Employee();
        System.out.println("Enter flatno : ");address.setFlat(Integer.parseInt(reader.readLine()));
        System.out.println("Enter City : ");address.setCity(reader.readLine());
        System.out.println("Enter pincode :");address.setPincode(Integer.parseInt(reader.readLine()));
        check = jdbcTemplate.update("INSERT INTO ADDRESS VALUES(?,?,?)",
                address.getFlat(),
                address.getCity(),
                address.getPincode());
        System.out.println("Enter ID ");employee.setEmpID(Integer.parseInt(reader.readLine()));
        System.out.println("Enter FirstName :");employee.setFirstName(reader.readLine());
        System.out.println("Enter lastName : ");employee.setLastName(reader.readLine());
        System.out.println("Enter Salary : ");employee.setSalary(Float.parseFloat(reader.readLine()));

         check = jdbcTemplate.update("INSERT INTO EMPLOYEE VALUES(?,?,?,?,?)",
                 employee.getEmpID(),
                 employee.getFirstName(),
                 employee.getLastName(),
                 employee.getSalary(),
                 address.getFlat());
        // adding flatno in Employee
        if(check!=0) System.out.println("RECORD ADDED SUCCESSFULLY!! " );
        else System.out.println("SOMETHING WENT WRONG !!");
    }

    @Override
    public void deleteData() throws IOException {
        System.out.println("Enter your id");
        int id = Integer.parseInt(reader.readLine());
        System.out.println("Enter your flat :");
        int flat=Integer.parseInt(reader.readLine());
        jdbcTemplate.update("DELETE FROM EMPLOYEE WHERE EMPID =?",id);
        check= jdbcTemplate.update("DELETE FROM ADDRESS WHERE FLATNO =?",flat);

       if(check!=0) System.out.println("RECORD DELETED SUCCESSFULLY !!");

    }

    @Override
    public void fetchData() {
        List<Employee> list =jdbcTemplate.query("SELECT * FROM EMPLOYEE ", new ResultSetExtractor<List<Employee>>() {
            @Override
            public List<Employee> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Employee> list = new ArrayList<>();
                while(resultSet.next()) {
                    employee = new Employee();
                    employee.setEmpID(resultSet.getInt(1));
                    employee.setFirstName(resultSet.getString(2));
                    employee.setLastName(resultSet.getString(3));
                    employee.setSalary(resultSet.getFloat(4));
                    list.add(employee);
                }
                return list;
            }
        });
        for(Employee employee1 : list)
                System.out.println(employee1);
    }

    @Override
    public void updateData() throws IOException {
        System.out.println("ENTER ID FOR SALARY UPADTE : ");
        int updateID= Integer.parseInt(reader.readLine());
        check = jdbcTemplate.update("UPDATE EMPLOYEE SET SALARY = (SALARY+5000) WHERE EMPID =?",
                updateID);
        if(check!=0) System.out.println("SALARY UPDATED SUCCESSFULLY !!");
    }

    @Override
    public void fetchBasedOnCondition() {
        List<Employee> list =jdbcTemplate.query("SELECT * FROM EMPLOYEE ", new ResultSetExtractor<List<Employee>>() {
            @Override
            public List<Employee> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Employee> list = new ArrayList<>();
                while(resultSet.next()) {
                    employee = new Employee();
                    employee.setEmpID(resultSet.getInt(1));
                    employee.setFirstName(resultSet.getString(2));
                    employee.setLastName(resultSet.getString(3));
                    employee.setSalary(resultSet.getFloat(4));
                    list.add(employee);
                }
                return list;
            }
        });
        list.stream().filter(employee->employee.getSalary()>10000).forEach(System.out::println);

    }

    @Override
    public void sortBasedOnCondition() {
        List<Employee> list =jdbcTemplate.query("SELECT * FROM EMPLOYEE ", new ResultSetExtractor<List<Employee>>() {
            @Override
            public List<Employee> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Employee> list = new ArrayList<>();
                while(resultSet.next()) {
                    employee = new Employee();
                    employee.setEmpID(resultSet.getInt(1));
                    employee.setFirstName(resultSet.getString(2));
                    employee.setLastName(resultSet.getString(3));
                    employee.setSalary(resultSet.getFloat(4));
                    list.add(employee);
                }
                return list;
            }
        });
        list.stream().sorted(Comparator.
                comparing(employee1 -> employee1.getFirstName())).forEach(System.out::println);
    }
}
