package com.openbeats.openbeatsdaw.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "conversations")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Conversations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer conversation_id;
    private Integer user1_id;
    private Integer user2_id;
}