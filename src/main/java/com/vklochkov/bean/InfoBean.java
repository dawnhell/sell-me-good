package com.vklochkov.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InfoBean {
    public String shopName;
    public String foundationDate;
    public String author;
    public String about;

    public InfoBean () {}

    public InfoBean (String shopName, String foundationDate, String author, String about) {
        this.shopName = shopName;
        this.foundationDate = foundationDate;
        this.author = author;
        this.about = about;
    }
}
