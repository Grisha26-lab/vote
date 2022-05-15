package com.avanesov.vote.web;

import com.avanesov.vote.app.domain.Vote;
import com.avanesov.vote.app.domain.VoteStats;
import com.avanesov.vote.app.domain.VoteValue;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class VoteApi {

    @Autowired
    private VoteService service;


    @PostMapping(path = "/votes")
    SaveVoteResponse save(@RequestBody SaveVoteRequest request) {

        Vote vote = new Vote();
        vote.setUserId(request.getUserId());
        vote.setValue(request.getVoteValue());
        boolean isAnswer = service.save(vote);
        SaveVoteResponse saveVoteResponse = new SaveVoteResponse();
        saveVoteResponse.setSaved(isAnswer);
        return saveVoteResponse;
    }


    @GetMapping("/votes/stats")
    public GetVoteStatsResponce getStats() {

        VoteStats voteStats = service.getStats();
        return GetVoteStatsResponce
                .builder()
                .totalY(voteStats.getTotalY())
                .totalN(voteStats.getTotalN())
                .build();
    }

}

@Getter
@Setter
class SaveVoteRequest {
    private UUID userId;
    private VoteValue voteValue;

}

@Getter
@Setter
class SaveVoteResponse {

    private boolean isSaved;

}

@Getter
@Builder
class GetVoteStatsResponce {
    private final long totalY;
    private final long totalN;

}

