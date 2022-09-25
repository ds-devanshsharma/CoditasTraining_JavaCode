package com.Collabration.FirstProject.FirstProject.Services;

import com.Collabration.FirstProject.FirstProject.Entities.CoditasIntern;
import com.Collabration.FirstProject.FirstProject.Entities.CoditasInternList;

import java.sql.SQLException;
import java.util.List;

public interface InternServices {
    public List<CoditasInternList> internList() throws SQLException;
    public CoditasIntern internDetailList(int internID) throws SQLException;
}
