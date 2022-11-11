package com.Round2.PIPRound2Application.repository;

import com.Round2.PIPRound2Application.entities.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {
}
