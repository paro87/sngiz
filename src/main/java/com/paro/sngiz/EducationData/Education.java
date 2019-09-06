package com.paro.sngiz.EducationData;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paro.sngiz.PersonalData.Employer;

import javax.persistence.*;

@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int educationId;
    private String finishDate;
    private String collegeType;
    private String collegeName;
    private String profession;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @JsonIgnore
    private Employer employer;

    public Education() {
    }

    public Education(String finishDate, String collegeType, String collegeName, String profession) {
        this.finishDate = finishDate;
        this.collegeType = collegeType;
        this.collegeName = collegeName;
        this.profession = profession;
    }

    public int getEducationId() {
        return educationId;
    }

    public void setEducationId(int educationId) {
        this.educationId = educationId;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getCollegeType() {
        return collegeType;
    }

    public void setCollegeType(String collegeType) {
        this.collegeType = collegeType;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
