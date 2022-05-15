package com.avanesov.vote.app.domain;

import lombok.*;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "votes")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Check(constraints = "value in ('Y','N')")
public class Vote {
    @Id
    @Type(type = "uuid-char")
    @Column(length = 36)
    private UUID userId;
    @Column( length = 1,updatable = false)
    @Enumerated(EnumType.STRING)
    private VoteValue value;
}
