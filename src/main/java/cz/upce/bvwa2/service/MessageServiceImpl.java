package cz.upce.bvwa2.service;

import cz.upce.bvwa2.db.entity.Message;
import cz.upce.bvwa2.db.entity.User;
import cz.upce.bvwa2.db.repository.MessageRepository;
import cz.upce.bvwa2.db.repository.UserRepository;
import cz.upce.bvwa2.model.message.MessageModel;
import cz.upce.bvwa2.model.message.SendMessageModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final UserRepository userRepository;
    private final MessageRepository messageRepository;

    @Override
    public List<MessageModel> getInboxMessages(String userUuid) {
        List<Message> messages = messageRepository.findMessageByUserToUuid(userUuid);

        messages.forEach(message -> {
            message.setIsRead(true);
            messageRepository.save(message);
        });

        return messages.stream()
                       .map(MessageModel::fromEntity)
                       .toList();
    }

    @Override
    public void sendMessage(String userUuid, SendMessageModel model) {
        User userFrom = userRepository.findByUuid(userUuid).orElseThrow(EntityNotFoundException::new);
        User userTo = userRepository.findByEmail(model.getUserEmailTo()).orElseThrow(EntityNotFoundException::new);
        Message message = new Message();
        message.setUserTo(userTo);
        message.setUserFrom(userFrom);
        message.setContent(model.getContent());
        message.setIsRead(false);
        message.setTime(new Date());
        messageRepository.save(message);
    }

    @Override
    public Boolean existsUnreadMessages(String userUuid) {
        return messageRepository.existsByUserToUuidAndIsReadIsFalse(userUuid);
    }
}
