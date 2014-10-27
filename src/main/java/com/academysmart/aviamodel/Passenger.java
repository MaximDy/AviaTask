package com.academysmart.aviamodel;

import javax.persistence.*;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_passenger_gen")
    @SequenceGenerator(name = "id_passenger_gen", sequenceName = "id_passenger_seq")
    private long id;
    private String firstName;
    private String secondName;
    private String patronymic;
    private String phoneNumber;

    public long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public String getPatronymic() {
        return this.patronymic;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
