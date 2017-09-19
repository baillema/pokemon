package database.entities;

import javax.persistence.*;

@Entity
@Table(name = "items_descriptions_translations", schema = "public", catalog = "pokemondb")
@IdClass(ItemsDescriptionsTranslationsEntityPK.class)
public class ItemsDescriptionsTranslationsEntity {
    private int itemDescriptionId;
    private int languageId;
    private String translation;
    private ItemsDescriptionsEntity itemsDescriptionsByItemDescriptionId;
    private LanguagesEntity languagesByLanguageId;

    @Id
    @Column(name = "item_description_id", nullable = false)
    public int getItemDescriptionId() {
        return itemDescriptionId;
    }

    public void setItemDescriptionId(int itemDescriptionId) {
        this.itemDescriptionId = itemDescriptionId;
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

        ItemsDescriptionsTranslationsEntity that = (ItemsDescriptionsTranslationsEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "item_description_id", referencedColumnName = "id", nullable = false)
    public ItemsDescriptionsEntity getItemsDescriptionsByItemDescriptionId() {
        return itemsDescriptionsByItemDescriptionId;
    }

    public void setItemsDescriptionsByItemDescriptionId(ItemsDescriptionsEntity itemsDescriptionsByItemDescriptionId) {
        this.itemsDescriptionsByItemDescriptionId = itemsDescriptionsByItemDescriptionId;
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
