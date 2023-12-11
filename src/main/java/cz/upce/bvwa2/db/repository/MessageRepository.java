package cz.upce.bvwa2.db.repository;

import cz.upce.bvwa2.db.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findMessageByUserFromUuid(String userFromUuid);
    List<Message> findMessageByUserToUuid(String userToUuid);
    Boolean existsByUserToUuidAndIsReadIsFalse(String userToUuid);
}
