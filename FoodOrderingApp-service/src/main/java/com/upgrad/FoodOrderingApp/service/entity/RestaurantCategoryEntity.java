package com.upgrad.FoodOrderingApp.service.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "RESTAURANT_CATEGORY")
@NamedQueries({
        @NamedQuery(name = "getRestaurantCategories", query = "select ci.category from RestaurantCategoryEntity ci " +
                "inner join ci.restaurant res inner join ci.category cat where res.id = :restaurant_id" )
})
public class RestaurantCategoryEntity {
    public RestaurantCategoryEntity() {}

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "item_id")
    private ItemEntity item;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "restaurant_id")
    private RestaurantEntity restaurant;

    public RestaurantEntity getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantEntity restaurant) {
        this.restaurant = restaurant;
    }

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ItemEntity getItem() {
        return item;
    }

    public void setItem(ItemEntity item) {
        this.item = item;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    /*@Override
    public String toString() {
        return "RestaurantCategoryEntity{" +
                "id=" + id +
                ", item=" + item +
                ", category=" + category +
                '}';
    }*/

    @Override
    public String toString() {
        return "RestaurantCategoryEntity{" +
                "id=" + id +
                ", item=" + item +
                ", restaurant=" + restaurant +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return new EqualsBuilder().append(this, obj).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this).hashCode();
    }
}