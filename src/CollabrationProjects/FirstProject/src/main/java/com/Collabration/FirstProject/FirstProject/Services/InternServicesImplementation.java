package com.Collabration.FirstProject.FirstProject.Services;

import com.Collabration.FirstProject.FirstProject.DAO.ConnectionImplementation;
import com.Collabration.FirstProject.FirstProject.Entities.CoditasIntern;
import com.Collabration.FirstProject.FirstProject.Entities.CoditasInternList;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Service
public class InternServicesImplementation implements InternServices{
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    CoditasInternList internList;
    List<CoditasInternList> list=new ArrayList<>();
    @Override
    public List<CoditasInternList> internList() throws SQLException {
        preparedStatement =ConnectionImplementation.
                ConnectionImplementation().prepareStatement("SELECT * FROM INTERN_LIST;");
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            internList = new CoditasInternList();
            internList.setInternID(resultSet.getInt(1));
            internList.setInternName(resultSet.getString(2));
            list.add(internList);
        }
        return list;
    }

    @Override
    public List<CoditasIntern> internDetailList(int internID) {
        return null;
    }
}
