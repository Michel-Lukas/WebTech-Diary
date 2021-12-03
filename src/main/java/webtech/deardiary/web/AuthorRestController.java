package webtech.deardiary.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webtech.deardiary.web.api.Author.Author;
import webtech.deardiary.web.api.Author.AuthorManipulationRequest;
import webtech.deardiary.web.api.Entry.Entry;
import webtech.deardiary.web.api.Entry.EntryManipulationRequest;
import webtech.deardiary.web.service.AuthorService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class AuthorRestController {

    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) { this.authorService = authorService; }

    @GetMapping(path = "/api/v1/authors")
    public ResponseEntity<List<Author>> fetchAuthors() { return ResponseEntity.ok(authorService.findAll());  }


    @GetMapping(path = "/api/v1/authors/{id}")
    public ResponseEntity<Author> fetchAuthorById(@PathVariable Long id) {
        var author = authorService.findById(id);
        return author != null ? ResponseEntity.ok(author) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/authors")
    public ResponseEntity<Void> createAuthor(@RequestBody AuthorManipulationRequest request) throws URISyntaxException {
        var author = authorService.create(request);
        URI uri = new URI("/api/v1/authors/" + author.getAuthor_ID());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/authors/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody AuthorManipulationRequest request) {

        var author = authorService.update(id, request);
        return author != null ? ResponseEntity.ok(author) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/authors/{id}")
    public ResponseEntity<Void> deleteAuthos(@PathVariable Long id) {
        boolean successful = authorService.deleteById(id);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
