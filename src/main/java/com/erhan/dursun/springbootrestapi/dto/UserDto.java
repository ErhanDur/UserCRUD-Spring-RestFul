package com.erhan.dursun.springbootrestapi.dto;

import javax.persistence.Column;

public class UserDto {

    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return "UserDto{" +
                "firstName='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                '}';
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
