package org.example.domain.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import org.example.domain.persistence.Rewards;

import java.io.Serializable;
import java.util.Date;

public class RewardsDto implements Serializable {
    private String name;
    private int price;
    private String category;

    public RewardsDto() {
    }

    public RewardsDto(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public RewardsDto(Rewards rewards){
        this.name = rewards.getName();
        this.price = rewards.getPrice();
        this.category = rewards.getCategory();
    }

@JsonInclude
public Rewards buildRewards(RewardsDto rewardsDtos){
    return new Rewards(null,this.getName(),this.getPrice(),this.getCategory());
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "RewardsDto{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}