package com.Springboot.Voting.Application.repository;

import com.Springboot.Voting.Application.entities.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;



@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {
    @Query(name = "SELECT * FROM party_detail where party_name like ?1",nativeQuery = true)
    List<Party> getByPartyName(String partyName);

    @Query(name = "SELECT * FROM party_detail where party_symbol like ?1",nativeQuery = true)
    List<Party> getByPartySymbol(String partyName);

//    @Query(value = "select symbolName from party_detail where symbolName=?1",nativeQuery = true)
//    String getSymbolName(String xyz);

//    Optional<Party> findByPartyName(Long id);


//    @Query(name = "SELECT * FROM party_detail where party_symbol like :'%checkSymbol%'",nativeQuery = true)
//    List<Party> checkPartySymbol(String checkSymbol);
}
