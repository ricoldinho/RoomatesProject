package edu.rico.roomates.model.dtos;

import java.time.LocalDate;

import edu.rico.roomates.model.enums.Gender;

public record RoomateRequestDTO(
                String firstName,
                String lastName,
                String email,
                String phone,
                String password,
                Gender gender,
                LocalDate dateOfBirth) {
}
