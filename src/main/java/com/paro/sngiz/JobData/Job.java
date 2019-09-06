package com.paro.sngiz.JobData;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paro.sngiz.PersonalData.Employer;

import javax.persistence.*;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int jobId;
    //private Date startDate;
    //private Date endDate;
    private String startDate;
    private String endDate;
    private String companyName;
    private String position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @JsonIgnore
    private Employer employer;

    public Job() {
    }

    public Job(String startDate, String endDate, String companyName, String position) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.companyName = companyName;
        this.position = position;
    }

    public String getStartDate() {
        return startDate;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }



    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }
}
