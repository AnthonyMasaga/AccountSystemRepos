package org.example.domain.dto;


import org.example.domain.persistence.Rewards;

import java.io.Serializable;
import java.util.Date;

public class RewardsDto implements Serializable {
    private String name;
    private int pace;


    public RewardsDto() {
    }

    public RewardsDto(String name, int pace) {

        this.name = name;
        this.pace= pace;


    }

    public RewardsDto(Rewards rewards){
        this.name = rewards.getName();
        this.pace = rewards.getPace();

    }

    public String getName() {
        return name;
    }

    public int getPace() {
        return pace;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPace(int pace) {
        this.pace = pace;
    }

    @Override
    public String toString() {
        return "RewardsDto{" +
                "name='" + name + '\'' +
                ", pace=" + pace +
                '}';
    }
}