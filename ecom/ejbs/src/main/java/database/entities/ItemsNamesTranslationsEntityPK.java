package database.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ItemsNamesTranslationsEntityPK implements Serializable {
    private int itemNameId;
    private int languageId;
    private String translation;

    @Column(name = "item_name_id", nullable = false)
    @Id
    public int getItemNameId() {
        return itemNameId;
    }

    public void setItemNameId(int itemNameId) {
        this.itemNameId = itemNameId;
    }

    @Column(name = "language_id", nullable = false)
    @Id
    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    @Column(name = "translation", nullable = false, length = 50)
    @Id
    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemsNamesTranslationsEntityPK that = (ItemsNamesTranslationsEntityPK) o;

        if (itemNameId != that.itemNameId) return false;
        if (languageId != that.languageId) return false;
        if (translation != null ? !translation.equals(that.translation) : that.translation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemNameId;
        result = 31 * result + languageId;
        result = 31 * result + (translation != null ? translation.hashCode() : 0);
        return result;
    }
}
