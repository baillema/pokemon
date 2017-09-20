package database.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "feedbacks", schema = "public", catalog = "pokemondb")
public class FeedbackEntity implements Serializable {
    private int id;
    private String text;
    private int mark;
    private int authorId;
    private int userId;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "text", nullable = false)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "mark", nullable = false)
    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Basic
    @Column(name = "author_id", nullable = false)
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeedbackEntity that = (FeedbackEntity) o;

        if (id != that.id) return false;
        if (mark != that.mark) return false;
        if (authorId != that.authorId) return false;
        if (userId != that.userId) return false;
        return text != null ? text.equals(that.text) : that.text == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + mark;
        result = 31 * result + authorId;
        result = 31 * result + userId;
        return result;
    }
}
