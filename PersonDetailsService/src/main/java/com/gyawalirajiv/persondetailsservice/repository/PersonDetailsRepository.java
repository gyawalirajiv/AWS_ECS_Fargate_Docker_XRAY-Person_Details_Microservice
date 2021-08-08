package com.gyawalirajiv.persondetailsservice.repository;

import com.gyawalirajiv.persondetailsservice.models.PersonDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonDetailsRepository extends JpaRepository<PersonDetails, Long> {

    Optional<PersonDetails> findByPersonId(Long personId);

}
