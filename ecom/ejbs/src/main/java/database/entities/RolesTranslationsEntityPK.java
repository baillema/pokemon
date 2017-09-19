package database.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class RolesTranslationsEntityPK implements Serializable {
    private int roleId;
    private int languageId;

    @Column(name = "role_id", nullable = false)
    @Id
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Column(name = "language_id", nullable = false)
    @Id
    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolesTranslationsEntityPK that = (RolesTranslationsEntityPK) o;

        if (roleId != that.roleId) return false;
        if (languageId != that.languageId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + languageId;
        return result;
    }
}
