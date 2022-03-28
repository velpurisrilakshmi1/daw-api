package com.openbeats.openbeatsdaw.Service;


import com.openbeats.openbeatsdaw.Entity.Messages;

import java.util.List;

public interface MessagesServices{
    public int saveMessages(Messages message);
    public List<Messages> getAllmessages();
    public Messages getmessagesById(int message_id);
    public void deletemessages(int message_id);
}