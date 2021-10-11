package org.example.domain.persistence;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "targetGoals")
public class Goals implements Serializable {
    private static final long serialVersionUID = -2282337134058330518L;

    private Long Id;
    private int dailyStepsTarget;
    private int stepsTaken;
    private int AnnualWeightTarget;
    private int CurrentWeight;

    private Set<Goals> goals;

    public Goals() {
    }

    public Goals(Long Id, int dailyStepsTarget, int stepsTaken, int annualWeightTarget, int currentWeight) {
        this.Id = Id;
        this.dailyStepsTarget = dailyStepsTarget;
        this.stepsTaken = stepsTaken;
        this.AnnualWeightTarget = annualWeightTarget;
        this.CurrentWeight = currentWeight;
    }
    @Id
    @JoinColumn(name = "Id")


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
    @Column(name ="dailyStepsTarget")

    public int getDailyStepsTarget() {
        return dailyStepsTarget;
    }

    public void setDailyStepsTarget(int dailyStepsTarget) {
        this.dailyStepsTarget = dailyStepsTarget;
    }
    @Column(name = "stepsTaken")

    public int getStepsTaken() {
        return stepsTaken;
    }

    public void setStepsTaken(int stepsTaken) {
        this.stepsTaken = stepsTaken;
    }
    @Column(name = "annualWeightTarget")

    public int getAnnualWeightTarget() {
        return AnnualWeightTarget;
    }

    public void setAnnualWeightTarget(int annualWeightTarget) {
        AnnualWeightTarget = annualWeightTarget;
    }
    @Column(name = "currentWeight")

    public int getCurrentWeight() {
        return CurrentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        CurrentWeight = currentWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goals goals1 = (Goals) o;
        return dailyStepsTarget == goals1.dailyStepsTarget && stepsTaken == goals1.stepsTaken && AnnualWeightTarget == goals1.AnnualWeightTarget && CurrentWeight == goals1.CurrentWeight && Objects.equals(Id, goals1.Id) && Objects.equals(goals, goals1.goals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, dailyStepsTarget, stepsTaken, AnnualWeightTarget, CurrentWeight, goals);
    }

    @Override
    public String toString() {
        return "Goals{" +
                "Id='" + Id + '\'' +
                ", dailyStepsTarget=" + dailyStepsTarget +
                ", stepsTaken=" + stepsTaken +
                ", AnnualWeightTarget=" + AnnualWeightTarget +
                ", CurrentWeight=" + CurrentWeight +
                ", goals=" + goals +
                '}';
    }
}