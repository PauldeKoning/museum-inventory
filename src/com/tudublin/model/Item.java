package com.tudublin.model;

import java.util.Date;

public class Item {

    private Date originDate;
    private String country;
    private String name;
    private String description;

    public Date getOriginDate() {
        return this.originDate;
    }

    public void setOriginDate(Date originDate) {
        this.originDate = originDate;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() { return this.name; }

    public void setName(String name) {
        this.name = name;
    }

}
