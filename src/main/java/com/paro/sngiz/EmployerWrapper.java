package com.paro.sngiz;

import com.paro.sngiz.AddressData.Address;
import com.paro.sngiz.BirthData.Birth;
import com.paro.sngiz.EducationData.Education;
import com.paro.sngiz.FamilyData.Family;
import com.paro.sngiz.JobData.Job;
import com.paro.sngiz.PersonalData.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

public class EmployerWrapper {

    @Autowired
    @Valid
    private Employer employer;
    @Autowired
    private Address address;
    @Autowired
    private Birth birth;
    @Autowired
    private List<Education> educationList;
    @Autowired
    private List<Job> jobList;
    @Autowired
    private List<Family> familyList;
    @Autowired
    private MultipartFile image;

    public EmployerWrapper() {

    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Birth getBirth() {
        return birth;
    }

    public void setBirth(Birth birth) {
        this.birth = birth;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
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

    public void addEducation(Education education){
        this.educationList.add(education);
    }

    public void addJob(Job job) {
        this.jobList.add(job);
    }

    public void addFamily(Family family){
        this.familyList.add(family);
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }


}
