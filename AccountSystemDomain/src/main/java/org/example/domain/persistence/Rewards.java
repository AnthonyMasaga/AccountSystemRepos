package org.example.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
@Entity
@Table(name = "Rewards")
public class Rewards implements Serializable {
    private static final long serialVersionUID = -2282337134058330518L;


    private Long VoucherId;
    private String name;
    private int price;
    private String category;


    public Rewards() {
    }

    public Rewards(Long voucherId, String name, int price, String category) {
        VoucherId = voucherId;
        this.name = name;
        this.price = price;
        this.category = category;
    }
    @Id
    @SequenceGenerator(name="SEQ_Rewards",sequenceName = "Rewards_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_Rewards")
    @Column(name = "reward_id")

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
    @Column(name = "price")

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Column(name = "category")

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rewards rewards = (Rewards) o;
        return price == rewards.price && Objects.equals(VoucherId, rewards.VoucherId) && Objects.equals(name, rewards.name) && Objects.equals(category, rewards.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(VoucherId, name, price, category);
    }

    @Override
    public String toString() {
        return "Rewards{" +
                "VoucherId=" + VoucherId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}







