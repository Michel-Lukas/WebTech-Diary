package webtech.deardiary.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import webtech.deardiary.web.api.Entry;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EntryRestController {

    private List<Entry> entries;

    public EntryRestController() {
        entries = new ArrayList<>();
        entries.add(new Entry(1, "Dear Diary", LocalDate.of(2020, 8, 31), LocalTime.of(18, 40)));
        entries.add(new Entry(2, "I don't know what to do", LocalDate.now(), LocalTime.now()));
    }

    @GetMapping(path = "/api/v1/entries")
    public ResponseEntity<List<Entry>> fetchEntries() { return ResponseEntity.ok(entries);  }
}
