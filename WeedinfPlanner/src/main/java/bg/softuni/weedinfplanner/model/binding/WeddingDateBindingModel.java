package bg.softuni.weedinfplanner.model.binding;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class WeddingDateBindingModel {
    private LocalDate date;

    @NotNull(message = "Date is required!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "Date cannot be in the past.")
    public LocalDate getDate() {
        return date;
    }

    public WeddingDateBindingModel setDate(LocalDate date) {
        this.date = date;
        return this;
    }
}
