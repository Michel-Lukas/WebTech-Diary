package webtech.deardiary.web.api;

public class EntryManipulationRequest {

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
