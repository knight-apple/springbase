package cn.knightapple.controller;

import cn.knightapple.entity.Shout;
import cn.knightapple.service.StompService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class StompController {
    Logger logger = LoggerFactory.getLogger(StompController.class);
    @Autowired
    private SimpMessageSendingOperations messaging;

    @Autowired
    StompService stompService;

    @MessageMapping("/marco")
    public Shout handleShout(Shout incoming) {
        logger.info("Received message:" + incoming.getMessage());
        Shout outgoing = new Shout();
        outgoing.setMessage("Polo");
        stompService.sendMessage(outgoing.getMessage());
        return outgoing;
    }

    @SubscribeMapping("/subscribe")
    public Shout handleSubscribe() {
        Shout outing = new Shout();
        outing.setMessage("subscribes");
        return outing;
    }

    @MessageMapping("/shout")
    @SendToUser("/queue/notifications")
    public Shout userStomp(Principal principal, Shout shout) {
        String name = principal.getName();
        String message = shout.getMessage();
        logger.info("认证的名字是：{}，收到的消息是：{}", name, message);
        System.out.println("认证的名字是：" + name + "，收到的消息是：" + message);
        return shout;
    }

    @MessageMapping("/singleShout")
    public void singleUser(Shout shout, StompHeaderAccessor stompHeaderAccessor) {
        String message = shout.getMessage();
        logger.info("接收到消息：" + message);
        Principal user = stompHeaderAccessor.getUser();
        messaging.convertAndSendToUser(user.getName(),"/queue/shouts",shout);
//        stompService.sendToUser(user, "/queue/shouts", shout.getMessage());
    }

    @MessageExceptionHandler
    public Throwable handleExceptions(Throwable t)
    {
        logger.error("stomp error"+t.getMessage());
        return t;
    }
}