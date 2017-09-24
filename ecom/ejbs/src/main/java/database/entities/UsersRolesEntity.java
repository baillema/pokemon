package database.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users_roles", schema = "public", catalog = "pokemondb")
public class UsersRolesEntity implements Serializable {
    private int userId;
    private int roleId;


    public UsersRolesEntity() {
    }

    public UsersRolesEntity(int userId, int roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "role_id", nullable = false)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersRolesEntity that = (UsersRolesEntity) o;

        if (userId != that.userId) return false;
        if (roleId != that.roleId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + roleId;
        return result;
    }
}
