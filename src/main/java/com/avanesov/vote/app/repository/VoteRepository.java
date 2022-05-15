package com.avanesov.vote.app.repository;

import com.avanesov.vote.app.domain.Vote;
import com.avanesov.vote.app.domain.VoteStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VoteRepository extends JpaRepository<Vote, UUID> {

    @Query(nativeQuery = true, value = "select" +
            " count(*) filter(where value = 'Y') as totalY," +
            " count(*) filter(where value = 'N') as totalN" +
            " from votes")
    VoteStats getStats();


}
