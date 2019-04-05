package com.luxoft.fullstack.challenge;

import java.util.Objects;

public class Student {

    private String studentId;

    private String firstName;

    private String lastName;

    private String nickName;

    private String address1;

    private String zipCode;

    private String city;

    private String country;

    public Student(String studentId, String firstName, String lastName, String nickName, String address1, String zipCode,
        String city, String country) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.address1 = address1;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getAddress1() {
        return address1;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId) &&
            Objects.equals(firstName, student.firstName) &&
            Objects.equals(lastName, student.lastName) &&
            Objects.equals(nickName, student.nickName) &&
            Objects.equals(address1, student.address1) &&
            Objects.equals(zipCode, student.zipCode) &&
            Objects.equals(city, student.city) &&
            Objects.equals(country, student.country);
    }
}
