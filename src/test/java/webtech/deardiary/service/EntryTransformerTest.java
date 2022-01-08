package webtech.deardiary.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import webtech.deardiary.persistence.EntryEntity;
import webtech.deardiary.web.service.EntryTransformer;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.doReturn;

public class EntryTransformerTest {

    private final EntryTransformer entryTransformer = new EntryTransformer();

    @Test
    @DisplayName("Should transform EntryEntity to Entry")
    void transformEntityTest() {
        var entryEntity = Mockito.mock(EntryEntity.class);
        doReturn(123L).when(entryEntity).getId();
        doReturn("Test Input").when(entryEntity).getInput();
        doReturn("12:30").when(entryEntity).getTime();
        doReturn("2022-07-01").when(entryEntity).getDate();

        var res = entryTransformer.transformEntity(entryEntity);

        assertThat(res.getID()).isEqualTo(123);
        assertThat(res.getInput()).isEqualTo("Test Input");
        assertThat(res.getTime()).isEqualTo("12:30");
        assertThat(res.getDate()).isEqualTo("2022-07-01");
    }
}
