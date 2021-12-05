package bg.softuni.weedinfplanner.model.service;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class WeddingDateServiceModel {
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public WeddingDateServiceModel setDate(LocalDate date) {
        this.date = date;
        return this;
    }
}
