package bros.lectures.fastcampus.chatservice.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class StompChatController {

    @MessageMapping("/chats")  // /pub/chats 로 메시지를 보내면 이 메서드가 호출된다.
    @SendTo("/sub/chats")  // /sub/chats 로 메시지를 보낸다.
    public String handleMessage(@Payload String message) {
        log.info("{} received", message);

        return message;
    }
}
