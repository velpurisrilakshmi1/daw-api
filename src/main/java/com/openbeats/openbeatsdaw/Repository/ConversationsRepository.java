package com.openbeats.openbeatsdaw.Repository;

import com.openbeats.openbeatsdaw.Entity.Conversations;
import org.springframework.data.repository.CrudRepository;

public interface ConversationsRepository extends CrudRepository<Conversations,Integer> {
    
}