package com.tudublin.model.item;


import com.tudublin.model.inspection.IInspection;

import java.util.Date;

public abstract class Item implements IItem {

    private Date originDate;
    private String country;
    private String name;
    private String description;
    private IInspection inspection;

    public Item(IInspection inspection) {
        this.inspection = inspection;
    }

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

    public IInspection getInspection() {
        return this.inspection;
    }
}
