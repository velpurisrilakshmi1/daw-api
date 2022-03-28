package com.openbeats.openbeatsdaw.Service;


import com.openbeats.openbeatsdaw.Entity.Conversations;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ConversationsService{
    public Integer saveConversations(Conversations conversation);
    public List<Conversations> getAllconversations();
    public Conversations getconversationsById(Integer conversation_id);
    public ResponseEntity<String> deleteconversations(Integer conversations_id);
}