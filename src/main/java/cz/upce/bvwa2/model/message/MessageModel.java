package cz.upce.bvwa2.model.message;

import cz.upce.bvwa2.db.entity.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageModel {
    private String uuid;
    private String userUuidFrom;
    private String userEmailFrom;
    private String userUuidTo;
    private String userEmailTo;
    private String content;
    private Boolean isRead;
    private Date time;

    public static MessageModel fromEntity(Message entity) {
        MessageModel model = new MessageModel();
        model.uuid = entity.getUuid();
        model.userUuidFrom = entity.getUserFrom().getUuid();
        model.userEmailFrom = entity.getUserFrom().getEmail();
        model.userUuidTo = entity.getUserTo().getUuid();
        model.userEmailTo = entity.getUserTo().getEmail();
        model.content = entity.getContent();
        model.isRead = entity.getIsRead();
        model.time = entity.getTime();
        return model;
    }
}
