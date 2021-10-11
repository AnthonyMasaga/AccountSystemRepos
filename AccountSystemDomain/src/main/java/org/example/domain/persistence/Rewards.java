package org.example.domain.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
@Entity
@Table(name = "Rewards")
public class Rewards implements Serializable {
    private static final long serialVersionUID = -2282337134058330518L;


    private Long VoucherId;
    private String name;
    private int pace;


    public Rewards() {
    }
    public Rewards(String id, String name, int pace) {
        this.VoucherId= VoucherId;
        this.name = name;
        this.pace = pace;

    }
    @Id
    @Column(name = "Voucher_Id")
    public Long getVoucherId() {
        return VoucherId;
    }

    public void setVoucherId(Long voucherId) {
        VoucherId = voucherId;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "dateIssued")
    public int getPace() {
        return pace;
    }

    public void setPace(int pace) {
        this.pace = pace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rewards rewards = (Rewards) o;
        return pace == rewards.pace && Objects.equals(VoucherId, rewards.VoucherId) && Objects.equals(name, rewards.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(VoucherId, name, pace);
    }

    @Override
    public String toString() {
        return "Rewards{" +
                "VoucherId=" + VoucherId +
                ", name='" + name + '\'' +
                ", pace=" + pace +
                '}';
    }
}







