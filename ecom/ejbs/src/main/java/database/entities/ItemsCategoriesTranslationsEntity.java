package database.entities;

import javax.persistence.*;

@Entity
@Table(name = "items_categories_translations", schema = "public", catalog = "pokemondb")
@IdClass(ItemsCategoriesTranslationsEntityPK.class)
public class ItemsCategoriesTranslationsEntity {
    private int itemCategoryId;
    private int languageId;
    private String translation;
    private ItemCategoriesEntity itemCategoriesByItemCategoryId;
    private LanguagesEntity languagesByLanguageId;

    @Id
    @Column(name = "item_category_id", nullable = false)
    public int getItemCategoryId() {
        return itemCategoryId;
    }

    public void setItemCategoryId(int itemCategoryId) {
        this.itemCategoryId = itemCategoryId;
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

        ItemsCategoriesTranslationsEntity that = (ItemsCategoriesTranslationsEntity) o;

        if (itemCategoryId != that.itemCategoryId) return false;
        if (languageId != that.languageId) return false;
        if (translation != null ? !translation.equals(that.translation) : that.translation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemCategoryId;
        result = 31 * result + languageId;
        result = 31 * result + (translation != null ? translation.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "item_category_id", referencedColumnName = "id", nullable = false)
    public ItemCategoriesEntity getItemCategoriesByItemCategoryId() {
        return itemCategoriesByItemCategoryId;
    }

    public void setItemCategoriesByItemCategoryId(ItemCategoriesEntity itemCategoriesByItemCategoryId) {
        this.itemCategoriesByItemCategoryId = itemCategoriesByItemCategoryId;
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
