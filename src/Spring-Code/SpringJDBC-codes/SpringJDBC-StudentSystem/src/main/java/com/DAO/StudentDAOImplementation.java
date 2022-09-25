package com.DAO;

import com.bean.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImplementation implements StudentDAO{
    private JdbcTemplate jdbcTemplate;
    int id;
    Student student;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {

            this.jdbcTemplate = jdbcTemplate;

    }

    @Override
    public  int insertStudent(Student student) {
        return (jdbcTemplate.update("INSERT INTO STUDENT VALUES(?,?,?,?,?)",
                            student.getId(),
                            student.getName(),
                            student.getCity(),
                            student.getRating(),
                            student.getPassword()));

    }

    @Override
    public int updateStudent() {
        return 0;
    }

    @Override
    public int deleteStudent() {

        return 0;
    }

    @Override
    public List<Student> fetchStudent() {
        return jdbcTemplate.query("SELECT * FROM STUDENT ",
                new ResultSetExtractor<List<Student>>() {
                    @Override
                    public List<Student> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                        List<Student> list =new ArrayList<>();
                        while(resultSet.next()){
                            student=new Student();
                            student.setId(resultSet.getInt(1));
                            student.setName(resultSet.getString(2));
                            student.setCity(resultSet.getString(3));
                            student.setRating(resultSet.getFloat(4));
                            student.setPassword(resultSet.getString(5));
                            list.add(student);
                        }
                        return list;
                    }
                });
    }
}
