package org.example.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.domain.persistence.Miles;
import org.example.domain.persistence.User;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

public class MilesDto implements Serializable{
    private String email;
    private int Miles;
    private Date DateCompleted;
    private  int spending;
    private  int healthandsafety;
    private  int driving;

    public MilesDto() {
    }

    public MilesDto(String email, int miles, Date dateCompleted, int spending, int healthandsafety, int driving) {
        this.email = email;
        this.Miles = miles;
        this.DateCompleted = dateCompleted;
        this.spending = spending;
        this.healthandsafety = healthandsafety;
        this.driving = driving;
    }

    public MilesDto(Miles userDtos) {
        this.email = userDtos.getEmail();
        this.spending = userDtos.getSpending();
        this.healthandsafety = userDtos.getHealthandsafety();
        this.driving = userDtos.getDriving();
    }

    @JsonIgnore
    public Miles buildMiles(UserDto userDtos){
        return new Miles(null,this.getEmail(),this.getMiles(),this.getDateCompleted(),this.getSpending(),this.getHealthandsafety(),this.getDriving(),userDtos.buildPerson(userDtos));
    }

    public MilesDto(String email,int miles, int spending, int healthandsafety, int driving, User user ){
        email = email;
        miles= miles;
        this.spending = spending;
        this.healthandsafety = healthandsafety;
        this.driving = driving;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMiles() {
        return Miles;
    }

    public void setMiles(int miles) {
        Miles = miles;
    }

    public Date getDateCompleted() {
        return DateCompleted;
    }

    public void setDateCompleted(Date dateCompleted) {
        DateCompleted = dateCompleted;
    }

    public int getSpending() {
        return spending;
    }

    public void setSpending(int spending) {
        this.spending = spending;
    }

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

    @Override
    public String toString() {
        return "MilesDto{" +
                "email='" + email + '\'' +
                ", Miles=" + Miles +
                ", DateCompleted=" + DateCompleted +
                ", spending=" + spending +
                ", healthandsafety=" + healthandsafety +
                ", driving=" + driving +
                '}';
    }
}

