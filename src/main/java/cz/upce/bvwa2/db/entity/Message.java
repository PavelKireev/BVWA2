package cz.upce.bvwa2.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Message extends BaseEntity {

    private String content;

    @ManyToOne
    @JoinColumn(name = "user_uuid_from", referencedColumnName = "uuid")
    private User userFrom;

    @ManyToOne
    @JoinColumn(name = "user_uuid_to", referencedColumnName = "uuid")
    private User userTo;

    private Boolean isRead;
    private Date time;
}
