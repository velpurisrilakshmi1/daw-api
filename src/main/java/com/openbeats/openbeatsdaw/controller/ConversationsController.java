package com.openbeats.openbeatsdaw.controller;

import com.openbeats.openbeatsdaw.Entity.Conversations;
import com.openbeats.openbeatsdaw.Service.ConversationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/conversationsDetails")
public class ConversationsController{

    @Autowired
    private ConversationsService service;

    @PostMapping("/saveconversations")
     public ResponseEntity<Conversations> saveConversations(@RequestBody Conversations conversation){
        Integer conversation_id=service.saveConversations(conversation);
        return new ResponseEntity<Conversations>(HttpStatus.OK);
    }

    @GetMapping("/conversationslist")
    public ResponseEntity<List<Conversations>> getAllconversationsDetails(){
        List<Conversations> list=service.getAllconversations();
        return new ResponseEntity<List<Conversations>>(list,HttpStatus.OK);
    }

//    @RequestMapping(value = "/getconversationsbyid/{conversation_id}", method =GET)
//    @ResponseBody
//    @GetMapping("/getconversationsbyid/{conversation_id}")
//    @GetMapping("/getconversationsbyid/conversation_id/")
//    public ResponseEntity<Conversations> getconversationsById(@PathVariable("conversion_id") Integer conversation_id){
//        Conversations cnv=service.getconversationsById(conversation_id);
//        return new ResponseEntity<Conversations>(cnv,HttpStatus.OK);
//    }

    @GetMapping("/getconversationsbyid/{conversation_id}")
    public ResponseEntity<Conversations> getconversationsById(@PathVariable("conversation_id") Integer conversation_id){
        Conversations con=service.getconversationsById(conversation_id);
        return new ResponseEntity<Conversations>(con,HttpStatus.OK);
    }







//
//     @PutMapping("/updateconversations/{conversation_id}")
//    public ResponseEntity<String> updateconversations(@PathVariable("conversation_id") int conversation_id,@RequestBody Conversations conversation){
//        Conversations conversationFromDb=service.getconversationsById(conversation_id);
//        conversationFromDb.setuser1_id(conversation.getuser1_id());
//        conversationFromDb.setuser2_id(conversation.getuser2_id());
//
//        int conversation_id=service.saveconversations(conversationFromDb);
//        return new ResponseEntity<String>(conversation_id,HttpStatus.OK);
//
//    }



    @DeleteMapping("deleteconversations/{conversation_id}")

    public ResponseEntity<String> deleteconversations(@PathVariable("conversation_id") Integer conversation_id){
        service.deleteconversations(conversation_id);
        return new ResponseEntity<String>("conversation with'"+conversation_id+"'has been deleted",HttpStatus.OK);
    }


}