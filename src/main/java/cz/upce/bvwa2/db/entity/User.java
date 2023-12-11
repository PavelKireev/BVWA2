package cz.upce.bvwa2.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Types;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder()
@RequiredArgsConstructor
@Entity
@Table(name = "users")
@AllArgsConstructor
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phoneNumber;
    private String role;

    @Column(name = "profile_photo")
    @JdbcTypeCode(Types.VARBINARY)
    private byte[] profilePhoto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getFirstName(), user.getFirstName()) &&
               Objects.equals(getLastName(), user.getLastName()) &&
               Objects.equals(getPassword(), user.getPassword()) &&
               Objects.equals(getEmail(), user.getEmail()) &&
               Objects.equals(getPhoneNumber(), user.getPhoneNumber()) &&
               Objects.equals(getRole(), user.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getPassword(), getEmail(), getPhoneNumber(), getRole());
    }
}
