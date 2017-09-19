package database.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "items_articles", schema = "public", catalog = "pokemondb")
public class ItemsArticlesEntity {
    private int id;
    private String name;
    private Float price;
    private String description;
    private Integer quantity;
    private int state;
    private int userId;
    private Integer itemNameId;
    private Integer itemCategoryId;
    private Integer itemDescriptionId;
    private Collection<FeedbackEntity> feedbacksById;
    private ArticlesStatesEntity articlesStatesByState;
    private UsersEntity usersByUserId;
    private ItemsNamesEntity itemsNamesByItemNameId;
    private ItemCategoriesEntity itemCategoriesByItemCategoryId;
    private ItemsDescriptionsEntity itemsDescriptionsByItemDescriptionId;
    private Collection<ItemsArticlesCartsEntity> itemsArticlesCartsById;
    private Collection<SuggestionsEntity> suggestionsById;
    private Collection<SuggestionsEntity> suggestionsById_0;

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

    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "quantity", nullable = true)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "state", nullable = false)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "item_name_id", nullable = true)
    public Integer getItemNameId() {
        return itemNameId;
    }

    public void setItemNameId(Integer itemNameId) {
        this.itemNameId = itemNameId;
    }

    @Basic
    @Column(name = "item_category_id", nullable = true)
    public Integer getItemCategoryId() {
        return itemCategoryId;
    }

    public void setItemCategoryId(Integer itemCategoryId) {
        this.itemCategoryId = itemCategoryId;
    }

    @Basic
    @Column(name = "item_description_id", nullable = true)
    public Integer getItemDescriptionId() {
        return itemDescriptionId;
    }

    public void setItemDescriptionId(Integer itemDescriptionId) {
        this.itemDescriptionId = itemDescriptionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemsArticlesEntity that = (ItemsArticlesEntity) o;

        if (id != that.id) return false;
        if (state != that.state) return false;
        if (userId != that.userId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (itemNameId != null ? !itemNameId.equals(that.itemNameId) : that.itemNameId != null) return false;
        if (itemCategoryId != null ? !itemCategoryId.equals(that.itemCategoryId) : that.itemCategoryId != null)
            return false;
        if (itemDescriptionId != null ? !itemDescriptionId.equals(that.itemDescriptionId) : that.itemDescriptionId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + state;
        result = 31 * result + userId;
        result = 31 * result + (itemNameId != null ? itemNameId.hashCode() : 0);
        result = 31 * result + (itemCategoryId != null ? itemCategoryId.hashCode() : 0);
        result = 31 * result + (itemDescriptionId != null ? itemDescriptionId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "itemsArticlesByItemId")
    public Collection<FeedbackEntity> getFeedbacksById() {
        return feedbacksById;
    }

    public void setFeedbacksById(Collection<FeedbackEntity> feedbacksById) {
        this.feedbacksById = feedbacksById;
    }

    @ManyToOne
    @JoinColumn(name = "state", referencedColumnName = "id", nullable = false)
    public ArticlesStatesEntity getArticlesStatesByState() {
        return articlesStatesByState;
    }

    public void setArticlesStatesByState(ArticlesStatesEntity articlesStatesByState) {
        this.articlesStatesByState = articlesStatesByState;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UsersEntity getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(UsersEntity usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "item_name_id", referencedColumnName = "id")
    public ItemsNamesEntity getItemsNamesByItemNameId() {
        return itemsNamesByItemNameId;
    }

    public void setItemsNamesByItemNameId(ItemsNamesEntity itemsNamesByItemNameId) {
        this.itemsNamesByItemNameId = itemsNamesByItemNameId;
    }

    @ManyToOne
    @JoinColumn(name = "item_category_id", referencedColumnName = "id")
    public ItemCategoriesEntity getItemCategoriesByItemCategoryId() {
        return itemCategoriesByItemCategoryId;
    }

    public void setItemCategoriesByItemCategoryId(ItemCategoriesEntity itemCategoriesByItemCategoryId) {
        this.itemCategoriesByItemCategoryId = itemCategoriesByItemCategoryId;
    }

    @ManyToOne
    @JoinColumn(name = "item_description_id", referencedColumnName = "id")
    public ItemsDescriptionsEntity getItemsDescriptionsByItemDescriptionId() {
        return itemsDescriptionsByItemDescriptionId;
    }

    public void setItemsDescriptionsByItemDescriptionId(ItemsDescriptionsEntity itemsDescriptionsByItemDescriptionId) {
        this.itemsDescriptionsByItemDescriptionId = itemsDescriptionsByItemDescriptionId;
    }

    @OneToMany(mappedBy = "itemsArticlesByIdItemsArticles")
    public Collection<ItemsArticlesCartsEntity> getItemsArticlesCartsById() {
        return itemsArticlesCartsById;
    }

    public void setItemsArticlesCartsById(Collection<ItemsArticlesCartsEntity> itemsArticlesCartsById) {
        this.itemsArticlesCartsById = itemsArticlesCartsById;
    }

    @OneToMany(mappedBy = "itemsArticlesByItemArticleId")
    public Collection<SuggestionsEntity> getSuggestionsById() {
        return suggestionsById;
    }

    public void setSuggestionsById(Collection<SuggestionsEntity> suggestionsById) {
        this.suggestionsById = suggestionsById;
    }

    @OneToMany(mappedBy = "itemsArticlesByItemArticleCoupledId")
    public Collection<SuggestionsEntity> getSuggestionsById_0() {
        return suggestionsById_0;
    }

    public void setSuggestionsById_0(Collection<SuggestionsEntity> suggestionsById_0) {
        this.suggestionsById_0 = suggestionsById_0;
    }
}
