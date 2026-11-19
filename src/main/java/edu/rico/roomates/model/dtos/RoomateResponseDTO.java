package edu.rico.roomates.model.dtos;

import java.time.LocalDate;

import edu.rico.roomates.model.enums.Gender;

public record RoomateResponseDTO(
        Long id,
        String firstName,
        String lastName,
        String email,
        String phone,
        Gender gender,
        LocalDate dateOfBirth) {
}
