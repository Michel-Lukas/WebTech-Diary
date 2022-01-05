package webtech.deardiary.web.api;

public class Entry {

    private long ID;
    private String Input;
    private String date;
    private String time;

    public Entry(long ID, String input, String date, String time) {
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
