package com.paro.sngiz.FamilyData;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paro.sngiz.PersonalData.Employer;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Family{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int familyId;
    private String snfName;
    private String relationship;
    private String relBirthDate;
    private String relBirthPlace;
    private String relAddress;
    private String conviction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @JsonIgnore
    private Employer employer;

    public Family() {
    }

    public Family(String snfName, String relationship, String relBirthDate, String relBirthPlace, String relAddress, String conviction) {
        this.snfName = snfName;
        this.relationship = relationship;
        this.relBirthDate = relBirthDate;
        this.relBirthPlace=relBirthPlace;
        this.relAddress = relAddress;
        this.conviction=conviction;
    }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    public String getSnfName() {
        return snfName;
    }

    public void setSnfName(String snfName) {
        this.snfName = snfName;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getRelBirthDate() {
        return relBirthDate;
    }

    public void setRelBirthDate(String relBirthDate) {
        this.relBirthDate = relBirthDate;
    }

    public String getRelBirthPlace() {
        return relBirthPlace;
    }

    public void setRelBirthPlace(String relBirthPlace) {
        this.relBirthPlace = relBirthPlace;
    }

    public String getRelAddress() {
        return relAddress;
    }

    public void setRelAddress(String relAddress) {
        this.relAddress = relAddress;
    }

    public String getConviction() {
        return conviction;
    }

    public void setConviction(String conviction) {
        this.conviction = conviction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(snfName, family.snfName) &&
                Objects.equals(relationship, family.relationship) &&
                Objects.equals(relBirthDate, family.relBirthDate) &&
                Objects.equals(relAddress, family.relAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(snfName, relationship, relBirthDate, relAddress);
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }
}
