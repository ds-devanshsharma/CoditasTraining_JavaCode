package DAO;

import com.bean.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Implementation {
    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void method(){
         Student student = new Student();
         List<Student> list = jdbcTemplate.query("SELECT * FROM student", new ResultSetExtractor<List<Student>>() {
            @Override
            public List<Student> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Student> list1 = new ArrayList<>();
                while(resultSet.next()){
                    student.setId(resultSet.getInt(1));
                    student.setName(resultSet.getString(2));
                    student.setCity(resultSet.getString(3));
                    student.setRating(resultSet.getFloat(4));
                    student.setPassword(resultSet.getString(5));
                    list1.add(student);
                }
                return list1;
            }
        });
        list.stream().forEach(System.out::println);
    }
}
