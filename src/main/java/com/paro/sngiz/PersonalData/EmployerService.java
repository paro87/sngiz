package com.paro.sngiz.PersonalData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployerService {
    @Autowired
    private EmployerRepository employerRepository;

    public List<Employer> getAllEmployers(){
        List<Employer> employerList =new ArrayList<>();
        employerRepository.findAll().forEach(employerList::add);
        return employerList;
    }

    public void addEmployer(Employer employer) {
        employerRepository.save(employer);
    }

    public Employer getEmployer(int id) {
        return employerRepository.findById(id).orElse(null);
    }

    public void updateEmployer(int id, Employer employer){
        employerRepository.save(employer);
    }

    public void deleteEmployer(int id){
        employerRepository.deleteById(id);
    }

    public void saveEmployer(Employer employer){ employerRepository.save(employer);}



    public List<Employer> getEmployerByFirstname(String value){
         return employerRepository.findByFirstname(value);
    }

    public List<Employer> getEmployerBySurname(String value) {

        return employerRepository.findBySurname(value);
    }

    public List<Employer> getEmployerByFathersname(String value){
        return employerRepository.findByFathersname(value);
    }

    public List<Employer> getEmployerByIntpassport(String value){
        return employerRepository.findByIntpassport(value);
    }

    public List<Employer> getEmployerByDompassport(String value){
        return employerRepository.findByDompassport(value);
    }

    public List<Employer> getEmployerByNationality(String value){
        return employerRepository.findByNationality(value);
    }
    /*
    public List<Employer> getEmployerByBirthday(String value){
        return employerRepository.findByBirthday(value);
    }
    */
    public List<Employer> getEmployerByEducation(String value){
        return employerRepository.findByEducation(value);
    }

    public List<Employer> getEmployerByFamilystatus(String value){
        return employerRepository.findByFamilyStatus(value);
    }

    public List<Employer> getEmployerByEmail(String value){
        return employerRepository.findByEmail(value);
    }

    public List<Employer> getEmployerBySex(String value){
        return employerRepository.findBySex(value);
    }


    private void show(List<Employer> employers) {
        System.out.println("The results is: \n");
        for (Employer employer: employers
        ) {
            System.out.println(employer.getId()+" "+employer.getFirstname()+" "+employer.getSurname()+" "+employer.getIntpassport()+" "+employer.getDompassport());
        }
    }
}
