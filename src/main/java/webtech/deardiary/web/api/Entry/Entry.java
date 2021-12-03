package webtech.deardiary.web.api.Entry;

import java.time.LocalDate;
import java.time.LocalTime;

public class Entry {

    private long ID;
    private String Input;
    private LocalDate date;
    private LocalTime time;

    public Entry(long ID, String input, LocalDate date, LocalTime time) {
        this.ID = ID;
        Input = input;
        this.date = date;
        this.time = time;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
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
