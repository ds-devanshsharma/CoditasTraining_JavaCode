package com.SecondProject.CricketProject.services;

import com.SecondProject.CricketProject.Entities.Cricketer;
import com.SecondProject.CricketProject.Entities.CricketerList;

import java.util.List;

public interface CricketerServices {

    List<CricketerList> cricketerList();
    Cricketer cricketerDetail();
}
