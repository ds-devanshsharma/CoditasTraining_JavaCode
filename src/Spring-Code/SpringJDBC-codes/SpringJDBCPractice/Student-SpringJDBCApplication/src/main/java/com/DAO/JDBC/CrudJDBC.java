package com.DAO.JDBC;

import com.bean.Address;
import com.bean.Student;

public interface CrudJDBC {
    int insert(Student student);
    int insertAddress(Address address);
    int update();
    int delete();
    void fetch();
    void fetchBasedOnCondition();
}
