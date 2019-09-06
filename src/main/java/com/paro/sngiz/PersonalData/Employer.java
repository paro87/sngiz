package com.paro.sngiz.PersonalData;

import com.paro.sngiz.AddressData.Address;
import com.paro.sngiz.BirthData.Birth;
import com.paro.sngiz.EducationData.Education;
import com.paro.sngiz.FamilyData.Family;
import com.paro.sngiz.JobData.Job;
import com.paro.sngiz.Validator.EmployerId;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Employer implements Serializable {


    //@Pattern(regexp = "[1-9]{3}",message = "{Employer.validation.id.Pattern}")
    @NotNull(message = "{Employer.validation.id.NotNull}")
    @EmployerId
    @Id
    private int id;

    @Lob
    private byte[] photo;
    //@NotBlank(message = "{Employer.validation.intpassport.NotNull}")
    private String intpassport;
    //@NotBlank(message = "{Employer.validation.dompassport.NotNull}")
    private String dompassport;
    //@NotBlank(message = "{Employer.validation.firstname.NotNull}")
    private String firstname;
    //@NotBlank(message = "{Employer.validation.surname.NotNull}")
    private String surname;
    //@NotBlank(message = "{Employer.validation.fathersname.NotNull}")
    private String fathersname;
    //@NotNull(message = "{Employer.validation.birthday.NotNull}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String languages;
    //@NotBlank(message = "{Employer.validation.nationality.NotNull}")
    private String nationality;
    //@NotBlank(message = "{Employer.validation.education.NotNull}")
    private String education;
    //@NotBlank(message = "{Employer.validation.sex.NotNull}")
    private String sex;
    //@NotBlank(message = "{Employer.validation.familyStatus.NotNull}")
    private String familyStatus;
    private String email;
    private String prize;



    @OneToOne(mappedBy = "employer", cascade = CascadeType.ALL)
    //@JsonBackReference
    //@JsonIgnore
    private Address address;

    @OneToOne(mappedBy = "employer", cascade = CascadeType.ALL)
    //@JsonBackReference
    //@JsonIgnore
    private Birth birth;

    @OneToMany(mappedBy = "employer",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Education> educationList=new ArrayList<>();

    @OneToMany(mappedBy = "employer",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Job> jobList=new ArrayList<>();

    @OneToMany(mappedBy = "employer",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Family> familyList=new ArrayList<>();

    public Employer() {
    }

    public Employer(int id, String intpassport, String dompassport, String firstname, String surname, String fathersname, Date birthday, String nationality, String languages, String education, String sex, String familyStatus, String email, String prize) {
        this.id = id;
        this.intpassport = intpassport;
        this.dompassport = dompassport;
        this.firstname = firstname;
        this.surname = surname;
        this.fathersname = fathersname;
        this.birthday = birthday;
        this.nationality = nationality;
        this.languages=languages;
        this.education=education;
        this.sex = sex;
        this.familyStatus = familyStatus;
        this.email = email;
        this.prize = prize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getIntpassport() {
        return intpassport;
    }

    public void setIntpassport(String intpassport) {
        this.intpassport = intpassport;
    }

    public String getDompassport() {
        return dompassport;
    }

    public void setDompassport(String dompassport) {
        this.dompassport = dompassport;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFathersname() {
        return fathersname;
    }

    public void setFathersname(String fathersname) {
        this.fathersname = fathersname;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFamilyStatus() {
        return familyStatus;
    }

    public void setFamilyStatus(String familyStatus) {
        this.familyStatus = familyStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    public void addEducation(Education education){
        educationList.add(education);
        education.setEmployer(this);
    }

    public void removeEducation(Education education) {
        educationList.remove(education);
        education.setEmployer(null);
    }

    public Birth getBirth() {
        return birth;
    }

    public void setBirth(Birth birth) {
        this.birth = birth;
    }

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

    public List<Family> getFamilyList() {
        return familyList;
    }

    public void setFamilyList(List<Family> familyList) {
        this.familyList = familyList;
    }
}
