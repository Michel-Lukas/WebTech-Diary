package webtech.deardiary.web.api;

import java.time.LocalDate;
import java.time.LocalTime;

public class EntryManipulationRequest {

    private String Input;
    private LocalDate date;
    private LocalTime time;

    public EntryManipulationRequest(String input, LocalDate date, LocalTime time) {
        Input = input;
        this.date = date;
        this.time = time;
    }

    public String getInput() {
        return Input;
    }

    public void setInput(String input) {
        Input = input;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
