package cn.knightapple.service;

import java.security.Principal;

public interface StompService {
    void sendMessage(String message);

}
