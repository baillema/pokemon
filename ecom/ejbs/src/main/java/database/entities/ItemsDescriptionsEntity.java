package database.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "items_descriptions", schema = "public", catalog = "pokemondb")
public class ItemsDescriptionsEntity {
    private int id;
    private Collection<ItemsArticlesEntity> itemsArticlesById;
    private Collection<ItemsDescriptionsTranslationsEntity> itemsDescriptionsTranslationsById;

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

        ItemsDescriptionsEntity that = (ItemsDescriptionsEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @OneToMany(mappedBy = "itemsDescriptionsByItemDescriptionId")
    public Collection<ItemsArticlesEntity> getItemsArticlesById() {
        return itemsArticlesById;
    }

    public void setItemsArticlesById(Collection<ItemsArticlesEntity> itemsArticlesById) {
        this.itemsArticlesById = itemsArticlesById;
    }

    @OneToMany(mappedBy = "itemsDescriptionsByItemDescriptionId")
    public Collection<ItemsDescriptionsTranslationsEntity> getItemsDescriptionsTranslationsById() {
        return itemsDescriptionsTranslationsById;
    }

    public void setItemsDescriptionsTranslationsById(Collection<ItemsDescriptionsTranslationsEntity> itemsDescriptionsTranslationsById) {
        this.itemsDescriptionsTranslationsById = itemsDescriptionsTranslationsById;
    }
}
