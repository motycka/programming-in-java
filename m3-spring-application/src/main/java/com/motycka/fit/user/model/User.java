package com.motycka.fit.user.model;

import java.time.LocalDate;

public record User(
        Long id,
        String name,
        Double weight,
        LocalDate dateOfBirth
) {
    public User copy(Long id) {
        return new User(id, name, weight, dateOfBirth);
    }
}
