package com.openbeats.openbeatsdaw.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "messages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Messages{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int message_id;
//    private int conversation_id;
    private int sender_id;
    private boolean is_read;
    private String content;
    private Date created_at;


    @ManyToOne
    @JoinColumn(name="conversation_id", nullable=false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnoreProperties(value={"applications","hibernateLazyInitializer"})
    private Conversations conversations;
}