package webtech.deardiary.service;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import webtech.deardiary.persistence.EntryRepository;
import webtech.deardiary.web.service.EntryService;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EntryServiceTest implements WithAssertions {

    @Mock
    private EntryRepository entryRepository;

    @InjectMocks
    private EntryService testService;

    @Test
    @DisplayName("Should return true if delete method was successful")
    void deleteEntryTest() {
        Long testID = 123L;
        doReturn(true).when(entryRepository).existsById(testID);

        boolean res = testService.deleteById(testID);

        verify(entryRepository).deleteById(testID);
        assertThat(res).isTrue();
    }

    @Test
    @DisplayName("Should return false if Entry does not Exist")
    void noEntryTest() {
        Long testID = 123L;
        doReturn(false).when(entryRepository).existsById(testID);

        boolean res = testService.deleteById(testID);

        verifyNoMoreInteractions(entryRepository);
        assertThat(res).isFalse();
    }
}
