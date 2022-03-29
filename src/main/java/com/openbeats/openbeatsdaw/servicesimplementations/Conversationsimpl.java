package com.openbeats.openbeatsdaw.servicesimplementations;

import com.openbeats.openbeatsdaw.Entity.Conversations;
import com.openbeats.openbeatsdaw.Repository.ConversationsRepository;
import com.openbeats.openbeatsdaw.Service.ConversationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Conversationsimpl implements ConversationsService {

    @Autowired
    private ConversationsRepository repository;
    @Override
    public Integer saveConversations(Conversations conversation){

        return repository.save(conversation).getConversation_id();
    }
    @Override
    public List<Conversations> getAllconversations(){

        return (List<Conversations>)repository.findAll();
    }
    @Override
    public Conversations getconversationsById(Integer conversation_id){
        return repository.findById(conversation_id).get();
    }
//    @Override
//    public Optional<Conversations> getconversationsById(Integer conversation_id){
//        return repository.findById(conversation_id);
//    }



    @Override
    public void deleteconversations(Integer conversation_id){

        repository.deleteById(conversation_id);

    }

}