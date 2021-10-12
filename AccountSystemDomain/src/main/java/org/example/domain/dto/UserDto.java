package org.example.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.domain.persistence.User;
import java.io.Serializable;

public class UserDto implements Serializable {
    private String Name;
    private String Email;
    private long cell;
    private String address;
    private int age;
    private MilesDto milesDtos;

    public UserDto() {
    }

    public UserDto(String name, String email, long cell, String address, int age) {
        Name = name;
        Email = email;
        this.cell = cell;
        this.address = address;
        this.age = age;

    }
    public UserDto(String name, String email, long cell, String address,int age, MilesDto milesDtos) {
        Name = name;
        Email = email;
        this.cell = cell;
        this.address = address;
        this.age = age;
        this.milesDtos = milesDtos;

    }

    public UserDto(User user){
       this.address = user.getAddress();
       this.Name = user.getName();
       this.cell = user.getCell();
       this.Email= user.getEmail();
        if(null != user.getMiles()){
            this.milesDtos = new MilesDto(user.getMiles());
        }
    }
    @JsonIgnore
    public User buildPerson(UserDto userDto){
        return new User(null,this.getAddress(),this.getName(),this.getCell(),this.getEmail(),this.getAge());
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

    public MilesDto getMilesDto() {
        return milesDtos;
    }  public void setMilesDto(MilesDto milesDtos) {
        this.milesDtos = milesDtos;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
