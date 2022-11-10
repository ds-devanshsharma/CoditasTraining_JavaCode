package com.Round2.PIPRound2Application.repository;
import com.Round2.PIPRound2Application.entities.BookingEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeRepository extends CrudRepository<BookingEntity,Integer> {

}
