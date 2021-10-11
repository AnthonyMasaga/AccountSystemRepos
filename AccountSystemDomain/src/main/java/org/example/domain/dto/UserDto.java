package org.example.domain.dto;


import org.example.domain.persistence.User;
import java.io.Serializable;

public class UserDto implements Serializable {
    private String Name;
    private String Email;
    private long cell;
    private String address;

    public UserDto() {
    }

    public UserDto(String name, String email, long cell, String address) {
        Name = name;
        Email = email;
        this.cell = cell;
        this.address = address;
    }

    public UserDto(User customer){
       this.address = customer.getAddress();
       this.Name = customer.getName();
       this.cell = customer.getCell();
       this.Email= customer.getEmail();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public long getCell() {
        return cell;
    }

    public void setCell(long cell) {
        this.cell = cell;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", cell=" + cell +
                ", address='" + address + '\'' +
                '}';
    }
}
