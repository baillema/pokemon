package database.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "item_categories", schema = "public", catalog = "pokemondb")
public class ItemCategoriesEntity {
    private int id;
    private Collection<ItemsArticlesEntity> itemsArticlesById;
    private Collection<ItemsCategoriesTranslationsEntity> itemsCategoriesTranslationsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemCategoriesEntity that = (ItemCategoriesEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @OneToMany(mappedBy = "itemCategoriesByItemCategoryId")
    public Collection<ItemsArticlesEntity> getItemsArticlesById() {
        return itemsArticlesById;
    }

    public void setItemsArticlesById(Collection<ItemsArticlesEntity> itemsArticlesById) {
        this.itemsArticlesById = itemsArticlesById;
    }

    @OneToMany(mappedBy = "itemCategoriesByItemCategoryId")
    public Collection<ItemsCategoriesTranslationsEntity> getItemsCategoriesTranslationsById() {
        return itemsCategoriesTranslationsById;
    }

    public void setItemsCategoriesTranslationsById(Collection<ItemsCategoriesTranslationsEntity> itemsCategoriesTranslationsById) {
        this.itemsCategoriesTranslationsById = itemsCategoriesTranslationsById;
    }
}
