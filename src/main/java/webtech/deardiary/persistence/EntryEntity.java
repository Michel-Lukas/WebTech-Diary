package webtech.deardiary.persistence;

import javax.persistence.*;

@Entity(name = "Entries")
public class EntryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Text", nullable = false)
    private String input;

    @Column(name = "Date", nullable = false)
    private String date;

    @Column(name = "Time", nullable = false)
    private String time;

    public EntryEntity(String input, String date, String time) {
        this.input = input;
        this.date = date;
        this.time = time;
    }

    protected EntryEntity() {}

    public Long getId() {
        return id;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
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
