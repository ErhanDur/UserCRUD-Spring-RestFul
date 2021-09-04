package com.erhan.dursun.springbootrestapi.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@ToString
public class User extends BaseEntity {
    @Id
    @SequenceGenerator(name = "user_seq_gen",sequenceName = "user_gen",initialValue =100, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="user_seq_gen")
    @Column(name ="ID")
    private Long id;
    @Column(name ="FIRSTNAME",length =100)
    private String firstName;
    @Column(name ="LASTNAME",length =100)
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
