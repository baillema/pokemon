package database.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ItemsDescriptionsTranslationsEntityPK implements Serializable {
    private int itemDescriptionId;
    private int languageId;
    private String translation;

    @Column(name = "item_description_id", nullable = false)
    @Id
    public int getItemDescriptionId() {
        return itemDescriptionId;
    }

    public void setItemDescriptionId(int itemDescriptionId) {
        this.itemDescriptionId = itemDescriptionId;
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

        ItemsDescriptionsTranslationsEntityPK that = (ItemsDescriptionsTranslationsEntityPK) o;

        if (itemDescriptionId != that.itemDescriptionId) return false;
        if (languageId != that.languageId) return false;
        if (translation != null ? !translation.equals(that.translation) : that.translation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemDescriptionId;
        result = 31 * result + languageId;
        result = 31 * result + (translation != null ? translation.hashCode() : 0);
        return result;
    }
}
