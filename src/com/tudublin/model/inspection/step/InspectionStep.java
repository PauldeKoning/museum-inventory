package com.tudublin.model.inspection.step;

public abstract class InspectionStep implements IInspectionStep {

    private final String name;
    private final String instruction;
    protected String answer;

    public InspectionStep(String name, String instruction) {
        this.name = name;
        this.instruction = instruction;
    }

    public String getName() {
        return this.name;
    }

    public String getInstruction() {
        return this.instruction;
    }

    public String getAnswer() {
        return this.answer;
    }
}
