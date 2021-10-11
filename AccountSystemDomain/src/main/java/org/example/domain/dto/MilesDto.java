package org.example.domain.dto;

import org.example.domain.persistence.Miles;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

public class MilesDto implements Serializable{
    private String name;
    private String lastname;
    private int Miles;
    private Date DateComplete;

    public MilesDto() {
    }

    public MilesDto(String name, int miles, Date DateComplete) {
        this.name = name;

        Miles = miles;
        this.DateComplete = DateComplete;
    }
    public MilesDto(Miles miles){
       this.name = miles.getName();
       this.Miles = miles.getMiles();
       this.DateComplete =miles.getDateComplete();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getMiles() {
        return Miles;
    }
    public void setMiles(int miles) {
        Miles = miles;
    }
    public Date getDateComplete() {
        return DateComplete;
    }
    public void setDateStarted(Date dateStarted) {
        DateComplete = dateStarted;
    }

    @Override
    public String toString() {
        return "MilesDto{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", Miles=" + Miles +
                ", DateComplete=" + DateComplete +
                '}';
    }
}

