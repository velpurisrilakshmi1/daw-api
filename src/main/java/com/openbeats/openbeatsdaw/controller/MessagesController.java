package com.openbeats.openbeatsdaw.controller;

import com.openbeats.openbeatsdaw.Entity.Messages;
import com.openbeats.openbeatsdaw.Service.MessagesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messagesDetails")
public class MessagesController{

    @Autowired
    private MessagesServices service;

    @PostMapping("/savemessages")
    public ResponseEntity<Messages> saveMessages(@RequestBody Messages message){
        int message_id=service.saveMessages(message);
        return new ResponseEntity<Messages>( HttpStatus.OK);
    }

    @GetMapping("/messageslist")
    public ResponseEntity<List<Messages>> getAllmessagesDetails(){
        List<Messages> list=service.getAllmessages();
        return new ResponseEntity<List<Messages>>(list,HttpStatus.OK);
    }

    @GetMapping("/getmessagesbyid/{message_id}")
    public ResponseEntity<Messages> getmessagesById(@PathVariable("message_id") int message_id){
        Messages msg=service.getmessagesById(message_id);
        return new ResponseEntity<Messages>(msg,HttpStatus.OK);
    }
//
//    @PutMapping("/updatemessages/{message_id}")
//    public ResponseEntity<String> updatemessages(@PathVariable("message_id") int message_id,@RequestBody Messages message){
//        Messages messageFromDb=service.getmessagesById(message_id);
//        // messageFromDb.setconversation_id(message.getconversation_id());
//        messageFromDb.setsender_id(message.getsender_id());
//        messageFromDb.setis_read(message.getis_read());
//        messageFromDb.setcontent(message.content());
//        messageFromDb.setcreated_at(message.getcreaed_at());
//
//        int message_id=service.savemessages(messageFromDb);
//        return new ResponseEntity<String>(message_id,HttpStatus.OK);
//
//    }
    
    @DeleteMapping("deletemessages/{message_id}")
    public ResponseEntity<String> deletemessages(@PathVariable("message_id") int message_id){
        service.deletemessages(message_id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }


}