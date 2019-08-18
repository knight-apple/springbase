package cn.knightapple.service;

import cn.knightapple.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class StompServiceImpl implements StompService {
    @Autowired
    private SimpMessageSendingOperations messaging;
    @Override
    public void sendMessage(String message){
        messaging.convertAndSend("/topic/message",message);
    }


}
