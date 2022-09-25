package com.DAO.JDBC;
import com.bean.Address;
import com.bean.Student;
import org.springframework.jdbc.core.JdbcTemplate;

public class CrudJDBCImplementation implements CrudJDBC{
    private JdbcTemplate jdbcTemplate;
    @Override
    public int insertAddress( Address address) {
        return jdbcTemplate.update("INSERT INTO ADDRESS VALUES (?,?,?)"
                , address.getFlatNo()
                ,address.getCity()
                ,address.getPincode());
    }

    @Override
    public int insert(Student student) {
        return jdbcTemplate.update("INSERT INTO STUDENT VLAUES(?,?,?,?,?,?)"
                ,student.getStudentID()
                ,student.getFirstName()
                ,student.getLastName()
                ,student.getRating()
                ,student.getBatch()
                ,student.getAddress().getFlatNo());
    }

    @Override
    public int update() {
        return 0;
    }

    @Override
    public int delete() {
        return 0;
    }

    @Override
    public void fetch() {

    }

    @Override
    public void fetchBasedOnCondition() {

    }
}
