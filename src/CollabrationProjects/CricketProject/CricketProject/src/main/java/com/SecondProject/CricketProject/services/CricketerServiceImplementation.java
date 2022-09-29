package com.SecondProject.CricketProject.services;

import com.SecondProject.CricketProject.Entities.Award;
import com.SecondProject.CricketProject.Entities.Cricketer;
import com.SecondProject.CricketProject.Entities.CricketerList;
import com.SecondProject.CricketProject.JDBCConnection.ConnectionMaker;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Service
public class CricketerServiceImplementation implements CricketerServices{
    Cricketer cricketer ;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Award award;
    CricketerList cricketerList ;
    List<Award> awards;
    @Override
    public List<CricketerList> cricketerList() throws SQLException, ClassNotFoundException {
        List<CricketerList> list = new ArrayList<>();

        //fetching cricketer details
        preparedStatement = ConnectionMaker.getJDBCConnectionFromConnectionMaker()
                .prepareStatement("SELECT * FROM cricketer");
        ResultSet resultSet = preparedStatement.executeQuery();
        cricketerList = new CricketerList();
        if(resultSet.next()) {
            cricketerList.setId(resultSet.getInt(1));
            cricketerList.setName(resultSet.getString(2));
            list.add(cricketerList);
        }else{
            System.out.println("RECORD NOT FOUND !!");
        }
        return list;
    }

    @Override
    public Cricketer cricketerDetail(int id) throws SQLException, ClassNotFoundException {
        preparedStatement = ConnectionMaker.getJDBCConnectionFromConnectionMaker()
                .prepareStatement("SELECT * FROM awards WHERE CRICKETER_ID = ?");
        preparedStatement.setInt(1,id);
        resultSet = preparedStatement.executeQuery();
        award = new Award();
        awards = new ArrayList<>();
        if(resultSet.next()) {
            award.setAwardName(resultSet.getString(2));
            award.setDescription(resultSet.getNString(3));
            awards.add(award);
        }else{
            System.out.println("AWARD NOT FOUND !!");
        }

        //fetching cricketer details
        preparedStatement = ConnectionMaker.getJDBCConnectionFromConnectionMaker()
                .prepareStatement("SELECT * FROM CRICKETER WHERE CRICKETER_ID= ?");
        preparedStatement.setInt(1,id);
        resultSet = preparedStatement.executeQuery();
        cricketer = new Cricketer();
        if(resultSet.next()) {
            cricketer.setId(resultSet.getInt(1));
            cricketer.setName(resultSet.getString(2));
            cricketer.setAge(resultSet.getInt(3));
            cricketer.setNickName(resultSet.getString(4));
            cricketer.setBattingStyle(resultSet.getString(5));
            cricketer.setBowlingStyle(resultSet.getString(6));
            cricketer.setInstagramHandle(resultSet.getString(7));
            cricketer.setImgPath(resultSet.getString(8));
            cricketer.setAbout(resultSet.getNString(9));
            cricketer.setAwards(awards);
        }
        else{
            System.out.println("CRICKETER NOT FOUND !!");
        }

        return cricketer;
    }
}
