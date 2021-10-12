package org.example.domain.persistence;
import org.springframework.stereotype.Component;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
@Component
@Entity
@Table(name ="Miles")
public class Miles implements Serializable {
    private static final long serialVersionUID = -2282337134058330518L;

    private Long MilestoneId;
    private String email;
    private int Miles;
    private Date DateCompleted;
    private  int spending;
    private  int healthandsafety;
    private  int driving;
    private User user;

    //private Set<Miles> miles;


    public Miles() {
    }

    public Miles(Long milestoneId, String email, int miles, Date dateCompleted, int spending, int healthandsafety, int driving, User user) {
        this.MilestoneId = milestoneId;
        this.email = email;
        this.Miles = miles;
        this.DateCompleted = dateCompleted;
        this.spending = spending;
        this.healthandsafety = healthandsafety;
        this.driving = driving;
        this.user = user;
    }



    @Id
    @SequenceGenerator(name="SEQ_Miles",sequenceName = "Miles_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_Miles")
    @Column(name = "milestoneId")
    public Long getMilestoneId() {
        return MilestoneId;
    }
    public void setMilestoneId(Long milestoneId) {
        MilestoneId = milestoneId;
    }
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "Miles")
    public int getMiles() {
        return Miles;
    }
    public void setMiles(int miles) {
        Miles = miles;
    }

    @Column(name = "DateCompleted")
    public Date getDateCompleted() {
        return DateCompleted;
    }
    public void setDateCompleted(Date dateCompleted) {
        DateCompleted = dateCompleted;
    }
    @Column(name = "Spending")

    public int getSpending() {
        return spending;
    }

    public void setSpending(int spending) {
        this.spending = spending;
    }
    @Column(name = "healthandsafety")

    public int getHealthandsafety() {
        return healthandsafety;
    }

    public void setHealthandsafety(int healthandsafety) {
        this.healthandsafety = healthandsafety;
    }

    public int getDriving() {
        return driving;
    }

    public void setDriving(int driving) {
        this.driving = driving;
    }

   // @Column(name = "Driving")
    @OneToOne(cascade = CascadeType.PERSIST)
    @Column(name = "id")

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Miles miles = (Miles) o;
        return Miles == miles.Miles && spending == miles.spending && healthandsafety == miles.healthandsafety && driving == miles.driving && Objects.equals(MilestoneId, miles.MilestoneId) && Objects.equals(email, miles.email) && Objects.equals(DateCompleted, miles.DateCompleted) && Objects.equals(user, miles.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MilestoneId, email, Miles, DateCompleted, spending, healthandsafety, driving, user);
    }

    @Override
    public String toString() {
        return "Miles{" +
                "MilestoneId=" + MilestoneId +
                ", email='" + email + '\'' +
                ", Miles=" + Miles +
                ", DateCompleted=" + DateCompleted +
                ", spending=" + spending +
                ", healthandsafety=" + healthandsafety +
                ", driving=" + driving +
                ", user=" + user +
                '}';
    }
}
