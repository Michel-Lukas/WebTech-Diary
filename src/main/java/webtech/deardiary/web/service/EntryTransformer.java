package webtech.deardiary.web.service;

import org.springframework.stereotype.Service;
import webtech.deardiary.persistence.EntryEntity;
import webtech.deardiary.web.api.Entry;

@Service
public class EntryTransformer {

    public Entry transformEntity(EntryEntity entryEntity) {
        return new Entry(
                entryEntity.getId(),
                entryEntity.getInput(),
                entryEntity.getDate(),
                entryEntity.getTime()
        );
    }
}
