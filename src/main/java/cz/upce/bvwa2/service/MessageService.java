package cz.upce.bvwa2.service;

import cz.upce.bvwa2.model.message.MessageModel;
import cz.upce.bvwa2.model.message.SendMessageModel;

import java.util.List;

public interface MessageService {
    List<MessageModel> getInboxMessages(String userUuid);
    void sendMessage(String userUuid, SendMessageModel model);
    Boolean existsUnreadMessages(String userUuid);
}
