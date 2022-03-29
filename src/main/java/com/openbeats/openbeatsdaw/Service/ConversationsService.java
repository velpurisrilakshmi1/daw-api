package com.openbeats.openbeatsdaw.Service;


import com.openbeats.openbeatsdaw.Entity.Conversations;

import java.util.List;
import java.util.Optional;

public interface ConversationsService{
    public Integer saveConversations(Conversations conversation);
    public List<Conversations> getAllconversations();
    public Conversations getconversationsById(Integer conversation_id);
//    Optional<Conversations> getconversationsById(Integer conversation_id);
    public void deleteconversations(Integer conversations_id);
}