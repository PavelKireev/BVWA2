package cz.upce.bvwa2.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@RequiredArgsConstructor
@Entity
@AllArgsConstructor
public class Admin extends BaseEntity {

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

}
