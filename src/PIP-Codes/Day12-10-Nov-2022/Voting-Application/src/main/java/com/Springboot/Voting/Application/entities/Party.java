package com.Springboot.Voting.Application.entities;

import java.util.List;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Data
@Component
@Table(name = "party_detail")
public class Party {
    @Id
    @Column(name = "partyId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long partyId;

    @Column(name ="partyName" , nullable = false ,unique = true)
    private String partyName;

    @Column(name = "partySymbol" , nullable = false ,unique = true)
    private String partySymbol;

    @Column(name = "partySlogan" , nullable = false)
    private String partySlogan;

    @OneToMany(mappedBy = "party")
    private List<User> voterList;

}
