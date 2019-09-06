package com.paro.sngiz.AddressData;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paro.sngiz.PersonalData.Employer;

import javax.persistence.*;

@Entity
public class Address{
    @Id
    private int id;
    private String residenceCountry;
    private String residenceState;
    private String residenceCity;
    private String residenceRegion;
    private String residenceRestAddress;

    @OneToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "id")
    @MapsId //@MapsId tells Hibernate to use the id column of address as both primary key and foreign key.
    //@JsonManagedReference
    @JsonIgnore
    private Employer employer;

    public Address() {
    }

    public Address(String residenceCountry, String residenceState, String residenceCity, String residenceRegion, String residenceRestAddress) {
        this.residenceCountry = residenceCountry;
        this.residenceState = residenceState;
        this.residenceCity = residenceCity;
        this.residenceRegion = residenceRegion;
        this.residenceRestAddress=residenceRestAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResidenceCountry() {
        return residenceCountry;
    }

    public void setResidenceCountry(String residenceCountry) {
        this.residenceCountry = residenceCountry;
    }

    public String getResidenceState() {
        return residenceState;
    }

    public void setResidenceState(String residenceState) {
        this.residenceState = residenceState;
    }

    public String getResidenceCity() {
        return residenceCity;
    }

    public void setResidenceCity(String residenceCity) {
        this.residenceCity = residenceCity;
    }

    public String getResidenceRegion() {
        return residenceRegion;
    }

    public void setResidenceRegion(String residenceRegion) {
        this.residenceRegion = residenceRegion;
    }

    public String getResidenceRestAddress() {
        return residenceRestAddress;
    }

    public void setResidenceRestAddress(String residenceRestAddress) {
        this.residenceRestAddress = residenceRestAddress;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }
}
