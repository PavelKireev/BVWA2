package cz.upce.bvwa2.controller;

import cz.upce.bvwa2.model.message.MessageModel;
import cz.upce.bvwa2.model.message.SendMessageModel;
import cz.upce.bvwa2.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/message")
@RequiredArgsConstructor
public class MessageRestController {

    private final MessageService messageService;

    @GetMapping("inbox")
    public List<MessageModel> getInboxMessages(
        Authentication authentication
    ) {
        String userUuid = (String) ((Jwt)authentication.getPrincipal()).getClaims().get("uuid");
        return messageService.getInboxMessages(userUuid);
    }

    @PostMapping("send")
    public void sendMessage(
        Authentication authentication,
        @RequestBody SendMessageModel model
    ) {
        String userUuid = (String) ((Jwt)authentication.getPrincipal()).getClaims().get("uuid");
        messageService.sendMessage(userUuid, model);
    }

    @GetMapping("new-messages")
    public Boolean existsUnreadMessages(
        Authentication authentication
    ) {
        String userUuid = (String) ((Jwt)authentication.getPrincipal()).getClaims().get("uuid");
        return messageService.existsUnreadMessages(userUuid);
    }
}
