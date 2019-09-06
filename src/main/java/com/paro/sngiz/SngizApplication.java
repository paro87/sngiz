package com.paro.sngiz;

import com.paro.sngiz.AddressData.Address;
import com.paro.sngiz.AddressData.AddressRepository;
import com.paro.sngiz.PersonalData.Employer;
import com.paro.sngiz.PersonalData.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class SngizApplication {

    public static void main(String[] args) {
        SpringApplication.run(SngizApplication.class, args);
    }


}

