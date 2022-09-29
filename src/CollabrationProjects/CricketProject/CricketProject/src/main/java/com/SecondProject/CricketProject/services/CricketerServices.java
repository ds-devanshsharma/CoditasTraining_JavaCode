package com.SecondProject.CricketProject.services;

import com.SecondProject.CricketProject.Entities.Cricketer;
import com.SecondProject.CricketProject.Entities.CricketerList;
import java.sql.SQLException;
import java.util.List;

public interface CricketerServices {

    List<CricketerList> cricketerList() throws SQLException, ClassNotFoundException;
    Cricketer cricketerDetail(int id) throws SQLException, ClassNotFoundException;
}
