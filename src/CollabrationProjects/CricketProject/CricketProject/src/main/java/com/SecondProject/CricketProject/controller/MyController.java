package com.SecondProject.CricketProject.controller;

import com.SecondProject.CricketProject.Entities.Cricketer;
import com.SecondProject.CricketProject.Entities.CricketerList;
import com.SecondProject.CricketProject.services.CricketerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin(origins={"*"} , maxAge = 4800,allowCredentials = "false")
public class MyController {
    @Autowired
    CricketerServices cricketerServices;
    @GetMapping("/fetchCricketerNameAndID")
    List<CricketerList> cricketerListController() throws SQLException, ClassNotFoundException {
        return cricketerServices.cricketerList();
    }
    @GetMapping("/fetchCricketerDetailsBasedOnID/{id}")
    Cricketer cricketerDetailBasedOnIDController(@PathVariable String id) throws SQLException, ClassNotFoundException {
        return cricketerServices.cricketerDetail(Integer.parseInt(id));
    }

}
