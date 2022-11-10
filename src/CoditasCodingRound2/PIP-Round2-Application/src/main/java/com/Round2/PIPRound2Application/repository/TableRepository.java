package com.Round2.PIPRound2Application.repository;

import com.Round2.PIPRound2Application.entities.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface TableRepository extends JpaRepository<TableEntity,Integer> {
//  @Query("select t from TableEntity t where t.tableType >= ?1 and t.status in ?2")
//  TableEntity findTableIdBasedOnRequiredSeats(int tableType, Collection<String> statuses);

  @Query(value = "SELECT * FROM table_details WHERE TABLE_STATUS ='V' AND TABLE_TYPE >=:requirement " +
          " ORDER BY TABLE_TYPE LIMIT 1;",nativeQuery = true)
    TableEntity findTableIdBasedOnRequiredSeats(int requirement);
}
