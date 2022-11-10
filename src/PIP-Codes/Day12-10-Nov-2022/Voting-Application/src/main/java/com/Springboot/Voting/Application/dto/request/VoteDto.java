package com.Springboot.Voting.Application.dto.request;

import lombok.Data;

@Data
public class VoteDto {
    private Long userId;
    private Long partyId;
}
