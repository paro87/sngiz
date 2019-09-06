package com.paro.sngiz.AddressData;

import com.paro.sngiz.PersonalData.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Employer> {
}
