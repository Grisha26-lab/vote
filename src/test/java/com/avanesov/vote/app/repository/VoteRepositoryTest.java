package com.avanesov.vote.app.repository;

import com.avanesov.vote.app.domain.VoteStats;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class VoteRepositoryTest {

    @Autowired
    private VoteRepository repository;
    @Test
    void getStats() {
        VoteStats voteStats = repository.getStats();
        assertEquals(1,voteStats.getTotalY());
        assertEquals(2,voteStats.getTotalN());
    }
    @Test
    @Sql(statements = "delete from votes")
    void getStatsWhenNoVotes(){
        VoteStats voteStats = repository.getStats();
        assertEquals(0,voteStats.getTotalY());
        assertEquals(0,voteStats.getTotalN());

    }
}