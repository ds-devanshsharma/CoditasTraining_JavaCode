package com.JDBCAPI.RESTJDBCCar.service;
import com.JDBCAPI.RESTJDBCCar.JDBCutils.JdbcConnectionProvider;
import com.JDBCAPI.RESTJDBCCar.entities.Car;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Service
public class CarServiceImpl implements CarService {
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Car car ;

    @Override
    public void addCar(Car car) throws SQLException {

        preparedStatement = JdbcConnectionProvider.JdbcConnectionProviderMethod()
                .prepareStatement("INSERT INTO CAR values(?,?,?)");
        preparedStatement.setInt(1,car.getCarID());
        preparedStatement.setString(2,car.getCarName());
        preparedStatement.setFloat(3,car.getCarPrice());
        preparedStatement.executeUpdate();
    }

    @Override
    public Car viewCar(int carID) throws SQLException {
        preparedStatement = JdbcConnectionProvider.JdbcConnectionProviderMethod()
                .prepareStatement("SELECT * FROM CAR WHERE CAR_ID = ?");
        preparedStatement.setInt(1,carID);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        car =new Car();
        car.setCarID(resultSet.getInt(1));
        car.setCarName(resultSet.getString(2));
        car.setCarPrice(resultSet.getFloat(3));

        return car;
    }

    @Override
    public List<Car> viewCarList() throws SQLException {
        List<Car> carList = new ArrayList<>();
        preparedStatement = JdbcConnectionProvider.JdbcConnectionProviderMethod()
                .prepareStatement("SELECT * FROM CAR ");
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            car= new Car();
            car.setCarID(resultSet.getInt(1));
            car.setCarName(resultSet.getString(2));
            car.setCarPrice(resultSet.getFloat(3));
            carList.add(car);
        }
        return carList;
    }

    @Override
    public String  deleteCar(int carID) throws SQLException {
        preparedStatement = JdbcConnectionProvider.JdbcConnectionProviderMethod()
                .prepareStatement("DELETE FROM CAR WHERE CAR_ID = ? ");
        preparedStatement.setInt(1,carID);
        if(preparedStatement.executeUpdate()>0) {
          return "Record Deleted succcessfully !!";
        }
        return "SomeThing Went Wrong !!";
    }

    @Override
    public void updateCar(int carID) {

    }
}
