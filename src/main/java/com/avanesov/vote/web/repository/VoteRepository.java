package com.avanesov.vote.web.repository;

import com.avanesov.vote.app.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VoteRepository extends JpaRepository<Vote, UUID> {


}
