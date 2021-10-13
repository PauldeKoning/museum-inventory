package com.tudublin.model.inspection.step.impl;

import com.tudublin.model.inspection.step.InspectionStep;

public class CheckmarkStep extends InspectionStep {

    public CheckmarkStep(String name, String instruction) {
        super(name, instruction);
    }

    public void setAnswer(String answer) {
        if (isAnswerValid(answer))
            return;

        this.answer = answer;
    }

    public Boolean isAnswerValid(String answer) {
        return true;
    }

    public String getAnswerError() {
        return null;
    }

}
