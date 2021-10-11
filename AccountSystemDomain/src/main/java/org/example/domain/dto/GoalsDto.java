package org.example.domain.dto;

import org.example.domain.persistence.Goals;
import org.example.domain.persistence.Miles;

import java.io.Serializable;

public class GoalsDto implements Serializable {
    private int dailyStepsTarget;
    private int stepsTaken;
    private int AnnualWeightTarget;
    private int CurrentWeight;

    public GoalsDto() {
    }

    public GoalsDto(int dailyStepsTarget, int stepsTaken, int annualWeightTarget, int currentWeight) {
        this.dailyStepsTarget = dailyStepsTarget;
        this.stepsTaken = stepsTaken;
        AnnualWeightTarget = annualWeightTarget;
        CurrentWeight = currentWeight;
    }
    public GoalsDto(Goals goals){
        this.dailyStepsTarget = goals.getDailyStepsTarget();
        this.stepsTaken = goals.getStepsTaken();
        this.AnnualWeightTarget = goals.getAnnualWeightTarget();
        this.CurrentWeight =goals.getCurrentWeight();
    }

    public int getDailyStepsTarget() {
        return dailyStepsTarget;
    }

    public void setDailyStepsTarget(int dailyStepsTarget) {
        this.dailyStepsTarget = dailyStepsTarget;
    }

    public int getStepsTaken() {
        return stepsTaken;
    }

    public void setStepsTaken(int stepsTaken) {
        this.stepsTaken = stepsTaken;
    }

    public int getAnnualWeightTarget() {
        return AnnualWeightTarget;
    }

    public void setAnnualWeightTarget(int annualWeightTarget) {
        AnnualWeightTarget = annualWeightTarget;
    }

    public int getCurrentWeight() {
        return CurrentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        CurrentWeight = currentWeight;
    }

    @Override
    public String toString() {
        return "GoalsDto{" +
                "dailyStepsTarget=" + dailyStepsTarget +
                ", stepsTaken=" + stepsTaken +
                ", AnnualWeightTarget=" + AnnualWeightTarget +
                ", CurrentWeight=" + CurrentWeight +
                '}';
    }
}
