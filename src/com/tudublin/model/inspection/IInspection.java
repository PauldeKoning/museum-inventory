package com.tudublin.model.inspection;

import com.tudublin.model.inspection.step.IInspectionStep;

import java.util.ArrayList;

public interface IInspection {
    ArrayList<IInspectionStep> getInspectionSteps();
    IInspectionStep getInspectionStep(int i);
    int getInspectionStepAmount();
    int getMandatoryStepAmount();
    int addStep(IInspectionStep step);
    void removeStep(int i);
}
