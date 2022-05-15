package com.avanesov.vote.web;

import com.avanesov.vote.app.domain.Vote;
import com.avanesov.vote.web.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    @Autowired
    private VoteRepository repository;


        public boolean save(Vote vote){
          if (repository.existsById(vote.getUserId()))
    return false ;
        repository.save(vote);return true;

        }
}
