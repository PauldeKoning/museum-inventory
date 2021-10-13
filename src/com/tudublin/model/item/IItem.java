package com.tudublin.model.item;

import com.tudublin.model.inspection.IInspection;

import java.util.Date;

public interface IItem {
    void setOriginDate(Date originDate);

    String getRegion();
    void setRegion(String region);

    String getCountry();
    void setCountry(String country);

    String getDescription();
    void setDescription(String description);

    String getName();
    void setName(String name);

    IInspection getInspection();
}
