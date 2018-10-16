package com.vklochkov.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InfoBean {
    private String shopName;
    private String foundationDate;
    private String author;
    private String about;

    public InfoBean () {}

    public InfoBean (String shopName, String foundationDate, String author, String about) {
        this.shopName = shopName;
        this.foundationDate = foundationDate;
        this.author = author;
        this.about = about;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(String foundationDate) {
        this.foundationDate = foundationDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
