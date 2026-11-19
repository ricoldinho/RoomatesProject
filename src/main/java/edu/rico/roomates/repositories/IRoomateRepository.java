package edu.rico.roomates.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rico.roomates.model.entities.Roomate;

public interface IRoomateRepository extends JpaRepository<Roomate, Long> {

}
