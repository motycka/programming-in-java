package lesson04.encapsulation;

import java.time.LocalDate;

public class Animal {

    // birthDate holds internal state, and is not accessible from outside the class
    private LocalDate birthDate;

    // birthDate is only read through a getter
    public LocalDate getBirthDate() {
        return birthDate;
    }

    // birthDate is only changed through a setter, which ensures validation
    public void setBirthDate(LocalDate birthDate) {
        if (birthDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Birth date cannot be in the future");
        } else {
            this.birthDate = birthDate;
        }
    }
}
