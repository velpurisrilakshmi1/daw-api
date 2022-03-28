package com.openbeats.openbeatsdaw.servicesimplementations;

import com.openbeats.openbeatsdaw.Entity.Messages;
import com.openbeats.openbeatsdaw.Repository.MessagesRepository;
import com.openbeats.openbeatsdaw.Service.MessagesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Messagesimpl implements MessagesServices {

    @Autowired
    private MessagesRepository repository;

    @Override
    public int saveMessages(Messages message){
        return repository.save(message).getMessage_id();
    }
    @Override
    public List<Messages> getAllmessages(){
        return (List<Messages>)repository.findAll();
    }
    @Override
    public Messages getmessagesById(int message_id){
        return repository.findById(message_id).get();
    }
    @Override
    public void deletemessages(int message_id){
        repository.deleteById(message_id);
    }
}