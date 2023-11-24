package cz.upce.bvwa2.db.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@RequiredArgsConstructor
@Entity
@AllArgsConstructor
public class Admin {

    @Id
    private Long id;
    private String uuid;
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

}
