package com.tudublin.model.inspection.step;

public interface IInspectionStep {
    String getName();
    String getInstruction();
    String getAnswer();
    void setAnswer(String answer);
    Boolean isAnswerValid(String answer);
    String getAnswerError();
}
