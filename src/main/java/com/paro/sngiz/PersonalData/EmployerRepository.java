package com.paro.sngiz.PersonalData;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//<Employer, String> Employer-Entity, String-Id
//JpaRepository extends PagingAndSortingRepository which in turn extends CrudRepository
public interface EmployerRepository extends JpaRepository<Employer, Integer> {

    //List<Employer> findById(int name);
    List<Employer> findByFirstname(String name);
    List<Employer> findBySurname(String name);
    List<Employer> findByFathersname(String name);
    List<Employer> findByIntpassport(String name);
    List<Employer> findByDompassport(String name);
    List<Employer> findByBirthday(String name);
    //Languages should be tag in registration.html
    //List<Employer> findByLanguages(String name);
    List<Employer> findByNationality(String name);
    List<Employer> findByEducation(String name);
    List<Employer> findBySex(String name);
    List<Employer> findByFamilyStatus(String name);
    List<Employer> findByEmail(String name);

}
