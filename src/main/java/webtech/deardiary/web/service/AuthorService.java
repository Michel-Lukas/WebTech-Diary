package webtech.deardiary.web.service;

import org.springframework.stereotype.Service;
import webtech.deardiary.persistence.Author.AuthorEntity;
import webtech.deardiary.persistence.Author.AuthorRepository;
import webtech.deardiary.persistence.Entry.EntryEntity;
import webtech.deardiary.web.api.Author.Author;
import webtech.deardiary.web.api.Author.AuthorManipulationRequest;
import webtech.deardiary.web.api.Entry.Entry;
import webtech.deardiary.web.api.Entry.EntryManipulationRequest;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) { this.authorRepository = authorRepository; }

    public List<Author> findAll() {
        List<AuthorEntity> authors = authorRepository.findAll();
        return authors.stream()
                .map(this::transformAuthorEntity)
                .collect(Collectors.toList());
    }

    public Author findById(Long id) {
        var authorEntity = authorRepository.findById(id);
        return authorEntity.map(this::transformAuthorEntity).orElse(null);
    }

    private Author transformAuthorEntity(AuthorEntity authorEntity) {
        return new Author(
                authorEntity.getAuthor_ID(),
                authorEntity.getFirst_name(),
                authorEntity.getLast_name(),
                authorEntity.getNickname()
        );
    }

    public Author create(AuthorManipulationRequest request) {

        var authorEntity = new AuthorEntity(request.getFirst_name(),
                request.getLast_name(),
                request.getNickname());
        authorEntity = authorRepository.save(authorEntity);
        return transformAuthorEntity(authorEntity);
    }

    public Author update(Long id, AuthorManipulationRequest request) {
        var authorEntityOptional = authorRepository.findById(id);
        if (authorEntityOptional.isEmpty()) {
            return null;
        }
        var authorEntity = authorEntityOptional.get();
        authorEntity.setFirst_name(request.getFirst_name());
        authorEntity.setLast_name(request.getLast_name());
        authorEntity.setNickname(request.getNickname());
        authorEntity = authorRepository.save(authorEntity);

        return transformAuthorEntity(authorEntity);
    }

    public boolean deleteById(Long id){
        if (!authorRepository.existsById(id)) {
            return false;
        }

        authorRepository.deleteById(id);
        return true;
    }
}
