package com.Springboot.Voting.Application.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Data
@Component
@Table(name = "user_details")
public class User {
    @Id
    @Column(name = "userId")
    private Long userId;

    @Column(name = "username" , unique = true,nullable = false)
    private String userName;

    @Column(name = "userAge" ,nullable = false)
    private Long userAge;

    @Column(name = "userContact" , nullable = false,unique = true)
    private String userContact;

    @Column(name = "userPassword" ,nullable = false)
    private String userPassword;

    @Column(name = "userVoteGivenOrNot")
    private boolean voteGiven ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "partyId")
    private Party party;

}
