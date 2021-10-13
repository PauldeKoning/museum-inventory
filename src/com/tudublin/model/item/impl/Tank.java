package com.tudublin.model.item.impl;

import com.tudublin.model.inspection.impl.TankInspection;
import com.tudublin.model.item.Item;

public class Tank extends Item {

    public Tank() {
        super(new TankInspection());
    }

}
