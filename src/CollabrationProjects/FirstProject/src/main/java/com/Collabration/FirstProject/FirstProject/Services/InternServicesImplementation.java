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
    CoditasIntern intern;
    List<CoditasInternList> list;
    @Override
    public List<CoditasInternList> internList() throws SQLException {
        list=new ArrayList<>();
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
    public CoditasIntern internDetailList(int internID) throws SQLException {
        preparedStatement =ConnectionImplementation.
                ConnectionImplementation().prepareStatement("SELECT * FROM INTERN_LIST WHERE INTERN_ID = ?");
        preparedStatement.setInt(1,internID);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            intern = new CoditasIntern();
            intern.setInternID(resultSet.getInt(1));
            intern.setInternName(resultSet.getString(2));
            intern.setCity(resultSet.getString(3));
            intern.setBatchName(resultSet.getString(4));
            intern.setRating(resultSet.getFloat(5));
            intern.setImgPath(resultSet.getString(6));
        }
        return intern;
    }
}
