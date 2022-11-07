package com.Round2.PIPRound2Application.service;

import com.Round2.PIPRound2Application.entities.BookingDetails;
import com.Round2.PIPRound2Application.entities.TableStatus;
import com.Round2.PIPRound2Application.repository.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
public class CafeServiceImpl implements CafeService{
    @Autowired
    CafeRepository cafeRepository;
    @Autowired
    EntityManager manager;

    @Override
    public ResponseEntity addBooking(BookingDetails booking) {
        try{
            Query query =  manager.createQuery("from TableStatus inner join TableType on TableStatus.tableTypeId =" +
                    " TableType.tableId where tableStatus ='V' and TableType.countOfAvailableTable =:check");
            query.setParameter("check",booking.getNoOfSeatOfRequired());
            List list = query.getResultList();
            if(!list.isEmpty()){
                TableStatus table = cafeRepository.findById()
                booking

                return new ResponseEntity(HttpStatus.CREATED);
            }
            else{
                return new ResponseEntity("No Seats Available !! ",HttpStatus.NOT_FOUND);
            }

        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
