package webtech.deardiary.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webtech.deardiary.web.api.Entry;
import webtech.deardiary.web.api.EntryManipulationRequest;
import webtech.deardiary.web.service.EntryService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class EntryRestController {

    private final EntryService entryService;

    public EntryRestController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping(path = "/api/v1/entries")
    public ResponseEntity<List<Entry>> fetchEntries() { return ResponseEntity.ok(entryService.findAll());  }


    @GetMapping(path = "/api/v1/entries/{id}")
    public ResponseEntity<Entry> fetchEntryById(@PathVariable Long id) {
        var entry = entryService.findById(id);
        return entry != null ? ResponseEntity.ok(entry) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/entries")
    public ResponseEntity<Void> createEntry(@RequestBody EntryManipulationRequest request) throws URISyntaxException {
        var valid = validate(request);
        if (valid) {
            var entry = entryService.create(request);
            URI uri = new URI("/api/v1/entries/" + entry.getID());
            return ResponseEntity.created(uri).build();
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(path = "/api/v1/entries/{id}")
    public ResponseEntity<Entry> updateEntry(@PathVariable Long id, @RequestBody EntryManipulationRequest request) {

        var entry = entryService.update(id, request);
        return entry != null ? ResponseEntity.ok(entry) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/entries/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Long id) {
        boolean successful = entryService.deleteById(id);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    private boolean validate(EntryManipulationRequest request){
        return request.getInput() != null
                && !request.getInput().isBlank();
    }
}
