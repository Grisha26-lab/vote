package com.avanesov.vote.app.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "votes")
public class Vote {
    @Id
    private UUID userId;
    @Column(updatable = false)
    private VoteEnum isAnswer;
}
