package com.tudublin.model.inspection.impl;

import com.tudublin.model.inspection.Inspection;
import com.tudublin.model.inspection.step.impl.CheckmarkStep;
import com.tudublin.model.inspection.step.impl.NoteStep;

import java.util.ArrayList;
import java.util.List;

public class GunInspection extends Inspection {

    public GunInspection() {
        super(2);

        this.steps = new ArrayList<>(List.of(
                new CheckmarkStep("Cleaned Check", "Has the gun been cleaned?"),
                new NoteStep("Cleaned Notes", "Any specialities that arose while cleaning?")
        ));
    }

}
