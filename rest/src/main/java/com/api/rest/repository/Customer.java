package com.api.rest.repository;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "second_lastname")
    private String secondLastname;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "address")
    private String address;

    @Column(name = "city_of_residence")
    private String cityOfResidence;

    @Column(name = "type_document")
    private String typeDocument;

    @Column(name = "document")
    private String document;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSecondLastname() {
        return secondLastname;
    }

    public void setSecondLastname(String secondLastname) {
        this.secondLastname = secondLastname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCityOfResidence() {
        return cityOfResidence;
    }

    public void setCityOfResidence(String cityOfResidence) {
        this.cityOfResidence = cityOfResidence;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Customer(long id, String firstName, String secondName, String lastname, String secondLastname, String telephone, String address, String cityOfResidence, String typeDocument, String document) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastname = lastname;
        this.secondLastname = secondLastname;
        this.telephone = telephone;
        this.address = address;
        this.cityOfResidence = cityOfResidence;
        this.typeDocument = typeDocument;
        this.document = document;
    }
}
