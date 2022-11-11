package com.Round2.PIPRound2Application.repository;

import com.Round2.PIPRound2Application.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
}
