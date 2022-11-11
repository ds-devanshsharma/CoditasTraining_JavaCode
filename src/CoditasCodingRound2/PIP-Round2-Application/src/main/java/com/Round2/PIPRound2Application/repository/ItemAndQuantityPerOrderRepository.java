package com.Round2.PIPRound2Application.repository;
import com.Round2.PIPRound2Application.entities.OrderPerItemMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemAndQuantityPerOrderRepository extends JpaRepository<OrderPerItemMenu, Integer> {
}
