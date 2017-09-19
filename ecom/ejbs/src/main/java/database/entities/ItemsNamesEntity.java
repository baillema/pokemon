package database.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "items_names", schema = "public", catalog = "pokemondb")
public class ItemsNamesEntity {
    private int id;
    private Collection<ItemsArticlesEntity> itemsArticlesById;
    private Collection<ItemsNamesTranslationsEntity> itemsNamesTranslationsById;

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

        ItemsNamesEntity that = (ItemsNamesEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @OneToMany(mappedBy = "itemsNamesByItemNameId")
    public Collection<ItemsArticlesEntity> getItemsArticlesById() {
        return itemsArticlesById;
    }

    public void setItemsArticlesById(Collection<ItemsArticlesEntity> itemsArticlesById) {
        this.itemsArticlesById = itemsArticlesById;
    }

    @OneToMany(mappedBy = "itemsNamesByItemNameId")
    public Collection<ItemsNamesTranslationsEntity> getItemsNamesTranslationsById() {
        return itemsNamesTranslationsById;
    }

    public void setItemsNamesTranslationsById(Collection<ItemsNamesTranslationsEntity> itemsNamesTranslationsById) {
        this.itemsNamesTranslationsById = itemsNamesTranslationsById;
    }
}
