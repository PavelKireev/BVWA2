package cz.upce.bvwa2.db.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import org.hibernate.Hibernate;

import java.util.Objects;

@Data
@Entity
public abstract class User extends BaseEntity {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phoneNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
