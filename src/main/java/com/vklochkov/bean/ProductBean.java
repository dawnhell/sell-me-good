package com.vklochkov.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductBean {
    private int id;
    private int live;
    private int categoryId;
    private int unlimited;
    private float price;
    private float weight;
    private float stock;
    private String sku;
    private String name;
    private String cartDesc;
    private String shortDesc;
    private String longDesc;
    private String thumb;
    private String image;
    private String updateDate;
    private String location;

    public ProductBean() {}

    public ProductBean(int id, int live, int categoryId, int unlimited, float price, float weight, float stock, String sku, String name, String cartDesc, String shortDesc, String longDesc, String thumb, String image, String updateDate, String location) {
        this.id = id;
        this.live = live;
        this.categoryId = categoryId;
        this.unlimited = unlimited;
        this.price = price;
        this.weight = weight;
        this.stock = stock;
        this.sku = sku;
        this.name = name;
        this.cartDesc = cartDesc;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.thumb = thumb;
        this.image = image;
        this.updateDate = updateDate;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLive() {
        return live;
    }

    public void setLive(int live) {
        this.live = live;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getUnlimited() {
        return unlimited;
    }

    public void setUnlimited(int unlimited) {
        this.unlimited = unlimited;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCartDesc() {
        return cartDesc;
    }

    public void setCartDesc(String cartDesc) {
        this.cartDesc = cartDesc;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
