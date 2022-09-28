package com.Collabration.FirstProject.FirstProject.Controller;

import com.Collabration.FirstProject.FirstProject.Entities.CoditasIntern;
import com.Collabration.FirstProject.FirstProject.Entities.CoditasInternList;
import com.Collabration.FirstProject.FirstProject.Services.InternServices;
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
    InternServices internServices;
    @GetMapping("/fetchInternList")
    public List<CoditasInternList> controllerInternList() throws SQLException {
        return internServices.internList();
    }

    @GetMapping("/fetchIntern/{internID}")
    public CoditasIntern controllerCoditasIntern(@PathVariable String internID) throws SQLException {
        return internServices.internDetailList(Integer.parseInt(internID));
    }
}
