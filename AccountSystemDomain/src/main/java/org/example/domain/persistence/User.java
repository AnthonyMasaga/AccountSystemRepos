package org.example.domain.persistence;

import org.springframework.stereotype.Component;

import javax.persistence.*;
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
    private int age;
    private Miles miles;
    private Set<AccountTransaction> accountTransaction;


    private Set<Rewards> rewards;



    public User() {
    }

    public User(Long id, String name, String email, long cell, String address, int age ) {
        this.id = id;
        Name = name;
        Email = email;
        this.cell = cell;
        this.address = address;
        this.age = age;}

    public User(Long id, String name, String email, long cell, String address, int age,Miles miles , Set<AccountTransaction> accountTransaction ) {
        this.id = id;
        Name = name;
        Email = email;
        this.cell = cell;
        this.address = address;
        this.age = age;
        this.miles = miles;
        this.accountTransaction = accountTransaction;
        }


    @Id
    @SequenceGenerator(name="SEQ_User",sequenceName= " User_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_Person")
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
    @Column(name = "age")
    public int getAge() {
        return age;
    }public void setAge(int age) {
        this.age = age;
    }
    @OneToOne(targetEntity = Miles.class, fetch = FetchType.LAZY,optional = true, mappedBy = "user", cascade = CascadeType.PERSIST)
    public Miles getMiles() {
        return miles;
    }
    public void setMiles(Miles miles) {
        this.miles = miles;
    }
    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    public Set<AccountTransaction> getAccountTransaction() {
        return accountTransaction;
    }

    public void setAccountTransaction(Set<AccountTransaction> accountTransaction) {
        this.accountTransaction = accountTransaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return cell == user.cell && age == user.age && Objects.equals(id, user.id) && Objects.equals(Name, user.Name) && Objects.equals(Email, user.Email) && Objects.equals(address, user.address) && Objects.equals(miles, user.miles) && Objects.equals(accountTransaction, user.accountTransaction) && Objects.equals(rewards, user.rewards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Name, Email, cell, address, age, miles, accountTransaction, rewards);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", cell=" + cell +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", miles=" + miles +
                ", accountTransaction=" + accountTransaction +
                ", rewards=" + rewards +
                '}';
    }
}

