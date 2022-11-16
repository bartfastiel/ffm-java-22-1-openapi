package de.neuefische.ffmjava221.openapi.ffmjava221openapi;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;

public record User(
        @Min(1) int id,
        @Length(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
        String username) {
}
