package com.gyawalirajiv.personservice.repository;

import com.gyawalirajiv.personservice.models.PersonDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDetailsRepository extends JpaRepository<PersonDetails, Long> {
}
