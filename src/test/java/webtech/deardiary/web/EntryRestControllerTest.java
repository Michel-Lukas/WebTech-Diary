package webtech.deardiary.web;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Matches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import webtech.deardiary.web.api.Entry;
import webtech.deardiary.web.service.EntryService;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EntryRestController.class)
public class EntryRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EntryService entryService;

    @Test
    @DisplayName("Should return correct Entries from Entry Service")
    void getEntriesTest() throws Exception {
        var entries = List.of(
                new Entry(1, "Test1", "2021-31-12", "23:57"),
                new Entry(2,"Test2", "2022-01-01", "12:05")
        );
    doReturn(entries).when(entryService).findAll();

    mockMvc.perform(get("/api/v1/entries"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.size()").value(2))
            .andExpect(jsonPath("$[0].id").value(1))
            .andExpect(jsonPath("$[1].id").value(2))
            .andExpect(jsonPath("$[0].input").value("Test1"))
            .andExpect(jsonPath("$[0].time").value("23:57"))
            .andExpect(jsonPath("$[0].date").value("2021-31-12"))
            .andExpect(jsonPath("$[1].input").value("Test2"))
            .andExpect(jsonPath("$[1].time").value("12:05"))
            .andExpect(jsonPath("$[1].date").value("2022-01-01"));
    }

    @Test
    @DisplayName("Should return 404 if Entry is not found")
    void return404Test() throws Exception {
        doReturn(null).when(entryService).findById(anyLong());

        mockMvc.perform(get("/api/v1/entries/123"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Should return 201 and Location header when creating an Entry")
    void createEntryTest() throws Exception {
        String entryAsJson = "{\"input\": \"Test\", \"date\": \"2021-01-01\", \"time\": \"01:01\"}";
        var entry = new Entry(123, null, null, null);
        doReturn(entry).when(entryService).create(any());

        mockMvc.perform(
                post("/api/v1/entries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(entryAsJson)
        )
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo(("/api/v1/entries/" + entry.getID()))));
    }

    @Test
    @DisplayName("Should validate Entry Creation Request")
    void validateCreateEntryTest() throws Exception {
        String entryAsJson = "{\"input\": \"T\", \"date\": \"2021-01-01\", \"time\": \"01:01\"}";

        mockMvc.perform(
                post("/api/v1/entries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(entryAsJson)
        )
                .andExpect(status().isBadRequest());
    }
}
