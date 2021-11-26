package webtech.deardiary.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EntryRepository extends JpaRepository<EntryEntity, Long> {

    List<EntryEntity> findAllByDate(LocalDate date);
}
