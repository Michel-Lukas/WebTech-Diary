package webtech.deardiary.web.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EntryManipulationRequest {

    @Size(min = 4, message = "Please write down your thoughts in at least 4 characters.")
    @NotBlank(message = "Your entry cannot be left empty. Please write down your thoughts.")
    private String Input;

    private String date;
    private String time;

    public EntryManipulationRequest(String input, String date, String time) {
        Input = input;
        this.date = date;
        this.time = time;
    }

    public EntryManipulationRequest() {}

    public String getInput() {
        return Input;
    }

    public void setInput(String input) {
        Input = input;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
