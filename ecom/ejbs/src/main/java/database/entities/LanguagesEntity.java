package database.entities;

import database.consts.Requests;

import javax.persistence.*;

@Entity
@Table(name = "languages", schema = "public", catalog = "pokemondb")
@NamedQueries({
        @NamedQuery(name = Requests.LANGUAGES_ALL,
                query = "SELECT l " +
                        "FROM LanguagesEntity l"),

        @NamedQuery(name = Requests.LANGUAGES_FROM_ID,
                query = "SELECT l " +
                        "FROM LanguagesEntity l " +
                        "WHERE l.id = :id"),

        @NamedQuery(name = Requests.LANGUAGES_FROM_LANG,
                query = "SELECT l " +
                        "FROM LanguagesEntity l " +
                        "WHERE l.name = :str")
})
public class LanguagesEntity {
    public static String TEST = "ee";
    private int id;
    private String name;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LanguagesEntity entity = (LanguagesEntity) o;

        if (id != entity.id) {
            return false;
        }
        if (name != null ? !name.equals(entity.name) : entity.name != null) {
            return false;
        }

        return true;
    }
}