package com.vklochkov.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(
    name = "Info"
)
@XmlType(
    propOrder = {
        "shopName", "foundationDate", "author", "about"
    }
)
public class Info {
    private String shopName;
    private String foundationDate;
    private String author;
    private String about;

    public Info() {}

    public Info(String shopName, String foundationDate, String author, String about) {
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

    @Override
    public String toString() {
        return "Info{" +
            "shopName='" + shopName + '\'' +
            ", foundationDate='" + foundationDate + '\'' +
            ", author='" + author + '\'' +
            ", about='" + about + '\'' +
            '}';
    }
}
