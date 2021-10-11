package org.example.domain.persistence;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name ="Miles_Table")
public class Miles implements Serializable {
    private static final long serialVersionUID = -2282337134058330518L;

    private Long MilestoneId;
    private String name;
    private int Miles;
    private Date DateComplete;

    private Set<Miles> miles;

    public Miles() {
    }

    public Miles(Long Id,String name,int miles, Date DateComplete) {
        this.MilestoneId= MilestoneId;
        this.name = name;
        Miles = miles;
        this.DateComplete= DateComplete;

    }

    @Id
    @Column(name = "Id")
    public Long getMilestoneId() {
        return MilestoneId;
    }

    public void setMilestoneId(Long milestoneId) {
        MilestoneId = milestoneId;
    }




    @Column(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name = "MilesCompleted")
    public int getMiles() {
        return Miles;
    }
    public void setMiles(int miles) {
        Miles = miles;
    }

    @Column(name = "DateCompleted")
    public Date getDateComplete() {
        return DateComplete;
    }

    public void setDateComplete(Date dateComplete) {
        DateComplete = dateComplete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Miles miles1 = (Miles) o;
        return Miles == miles1.Miles && Objects.equals(MilestoneId, miles1.MilestoneId) && Objects.equals(name, miles1.name) && Objects.equals(DateComplete, miles1.DateComplete) && Objects.equals(miles, miles1.miles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MilestoneId, name, Miles, DateComplete, miles);
    }

    @Override
    public String toString() {
        return "Miles{" +
                "MilestoneId=" + MilestoneId +
                ", name='" + name + '\'' +
                ", Miles=" + Miles +
                ", DateComplete=" + DateComplete +
                ", miles=" + miles +
                '}';
    }
}
