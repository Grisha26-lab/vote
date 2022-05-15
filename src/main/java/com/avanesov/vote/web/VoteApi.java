package com.avanesov.vote.web;

import com.avanesov.vote.app.domain.Vote;
import com.avanesov.vote.app.domain.VoteEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class VoteApi {

    @Autowired
    private VoteService service;


    @PostMapping(path = "/votes")
     SaveVoteResponse save ( @RequestBody SaveVoteRequest request){

        Vote vote = new Vote();
        vote.setUserId(request.getUserId());
        vote.setIsAnswer(request.getVoteEnum());
         boolean isAnswer = service.save(vote);
         SaveVoteResponse saveVoteResponse = new SaveVoteResponse();
         saveVoteResponse.setSaved(isAnswer);
        return saveVoteResponse;
     }
}

@Getter
@Setter
class SaveVoteRequest{
    private UUID userId;
    private VoteEnum voteEnum;

}
@Getter
@Setter
class SaveVoteResponse{

    private boolean isSaved;

}


