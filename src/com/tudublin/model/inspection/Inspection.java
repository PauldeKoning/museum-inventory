package com.tudublin.model.inspection;

import com.tudublin.model.inspection.step.IInspectionStep;

import java.util.ArrayList;

public abstract class Inspection implements IInspection {

    private final int mandatoryStepAmount;
    protected ArrayList<IInspectionStep> steps;

    protected Inspection(int mandatoryStepAmount) {
        this.mandatoryStepAmount = mandatoryStepAmount;
    }

    public ArrayList<IInspectionStep> getInspectionSteps() {
        return this.steps;
    }

    public IInspectionStep getInspectionStep(int i) {
        return this.steps.get(i);
    }

    public int getInspectionStepAmount() {
        return this.steps.size();
    }

    public int getMandatoryStepAmount() {
        return this.mandatoryStepAmount;
    }

    public int addStep(IInspectionStep step) {
        this.steps.add(step);

        return this.steps.size() - 1;
    }

    public void removeStep(int i) {
        // If out of bounds or if current step is mandatory (aka, predefined)
        if (i >= 0 && i < steps.size() || i < this.mandatoryStepAmount) {
            return;
        }

        this.steps.remove(i);
    }

}
