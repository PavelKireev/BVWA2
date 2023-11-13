package cz.upce.bvwa2.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phoneNumber;
    private String role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getUsername(), user.getUsername()) &&
               Objects.equals(getFirstName(), user.getFirstName()) &&
               Objects.equals(getLastName(), user.getLastName()) &&
               Objects.equals(getPassword(), user.getPassword()) &&
               Objects.equals(getEmail(), user.getEmail()) &&
               Objects.equals(getPhoneNumber(), user.getPhoneNumber()) &&
               Objects.equals(getRole(), user.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getFirstName(), getLastName(),
                            getPassword(), getEmail(), getPhoneNumber(), getRole());
    }
}
