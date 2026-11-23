package edu.rico.roomates.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rico.roomates.model.entities.Roomate;
import edu.rico.roomates.model.enums.Gender;

public interface IRoomateRepository extends JpaRepository<Roomate, Long> {
    Roomate findByEmail(String email);

    List<Roomate> findByGender(Gender gender);
}
