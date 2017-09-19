package database.entities;

import javax.persistence.*;

@Entity
@Table(name = "items_names_translations", schema = "public", catalog = "pokemondb")
@IdClass(ItemsNamesTranslationsEntityPK.class)
public class ItemsNamesTranslationsEntity {
    private int itemNameId;
    private int languageId;
    private String translation;
    private ItemsNamesEntity itemsNamesByItemNameId;
    private LanguagesEntity languagesByLanguageId;

    @Id
    @Column(name = "item_name_id", nullable = false)
    public int getItemNameId() {
        return itemNameId;
    }

    public void setItemNameId(int itemNameId) {
        this.itemNameId = itemNameId;
    }

    @Id
    @Column(name = "language_id", nullable = false)
    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    @Id
    @Column(name = "translation", nullable = false, length = 50)
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

        ItemsNamesTranslationsEntity that = (ItemsNamesTranslationsEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "item_name_id", referencedColumnName = "id", nullable = false)
    public ItemsNamesEntity getItemsNamesByItemNameId() {
        return itemsNamesByItemNameId;
    }

    public void setItemsNamesByItemNameId(ItemsNamesEntity itemsNamesByItemNameId) {
        this.itemsNamesByItemNameId = itemsNamesByItemNameId;
    }

    @ManyToOne
    @JoinColumn(name = "language_id", referencedColumnName = "id", nullable = false)
    public LanguagesEntity getLanguagesByLanguageId() {
        return languagesByLanguageId;
    }

    public void setLanguagesByLanguageId(LanguagesEntity languagesByLanguageId) {
        this.languagesByLanguageId = languagesByLanguageId;
    }
}
