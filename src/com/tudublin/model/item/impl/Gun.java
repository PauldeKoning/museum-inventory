package com.tudublin.model.item.impl;

import com.tudublin.model.inspection.IInspection;
import com.tudublin.model.inspection.impl.GunInspection;
import com.tudublin.model.item.Item;

public class Gun extends Item {

    public Gun() {
        super(new GunInspection());
    }

}
