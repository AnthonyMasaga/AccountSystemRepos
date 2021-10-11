package org.example.domain.persistence;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
@Component
@Entity
@Table(name ="Customers")
public class User implements Serializable {
    private static final long serialVersionUID = -2282337134058330518L;

    private Long id;
    private String Name;
    private String Email;
    private long cell;
    private String address;

    private Set<Rewards> rewards;



    public User() {
    }

    public User(Long id, String name, String email, long cell, String address) {
        this.id = id;
        Name = name;
        Email = email;
        this.cell = cell;
        this.address = address;
    }

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "Name")
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Column(name = "Email")
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Column(name = "cell")
    public long getCell() {
        return cell;
    }

    public void setCell(long cell) {
        this.cell = cell;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User customer = (User) o;
        return id == customer.id && cell == customer.cell && Objects.equals(Name, customer.Name) && Objects.equals(Email, customer.Email) && Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Name, Email, cell, address);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", cell=" + cell +
                ", address='" + address + '\'' +
                '}';
    }
}

