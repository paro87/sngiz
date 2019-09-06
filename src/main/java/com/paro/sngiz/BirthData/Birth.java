package com.paro.sngiz.BirthData;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paro.sngiz.PersonalData.Employer;

import javax.persistence.*;

@Entity
public class Birth {
    @Id
    private int birthId;
    private String birthCountry;
    private String birthState;
    private String birthCity;
    private String birthAddressRest;

    @OneToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "id")
    @MapsId //@MapsId tells Hibernate to use the id column of address as both primary key and foreign key.
    //@JsonManagedReference
    @JsonIgnore
    private Employer employer;

    public Birth(){

    }

    public Birth(String birthCountry, String birthState, String birthCity, String birthAddressRest) {
        this.birthCountry = birthCountry;
        this.birthState = birthState;
        this.birthCity = birthCity;
        this.birthAddressRest = birthAddressRest;
    }

    public int getBirthId() {
        return birthId;
    }

    public void setBirthId(int birthId) {
        this.birthId = birthId;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public String getBirthState() {
        return birthState;
    }

    public void setBirthState(String birthState) {
        this.birthState = birthState;
    }

    public String getBirthAddressRest() {
        return birthAddressRest;
    }

    public void setBirthAddressRest(String birthAddressRest) {
        this.birthAddressRest = birthAddressRest;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }
}
