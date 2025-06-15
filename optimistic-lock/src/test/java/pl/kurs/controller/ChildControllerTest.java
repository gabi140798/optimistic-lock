package pl.kurs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.kurs.Application;
import pl.kurs.model.Child;
import pl.kurs.model.Mother;
import pl.kurs.model.command.CreateChildCommand;
import pl.kurs.model.command.UpdateChildCommand;
import pl.kurs.model.dto.ChildDto;
import pl.kurs.repository.MotherRepository;
import pl.kurs.service.ChildService;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ChildControllerTest {

    @Autowired
    private MockMvc postman;

    @Autowired
    private ChildService childService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MotherRepository motherRepository;

    @Test
    void shouldUpdateChild() throws Exception {
        Mother mother = new Mother();
        int motherId = motherRepository.saveAndFlush(mother).getId();
        ChildDto child = childService.createChild(new CreateChildCommand("Gabi", 60, 166,motherId));
        UpdateChildCommand command = new UpdateChildCommand("edit",20,170,0);
        int id = child.id();

        String json = objectMapper.writeValueAsString(command);

        System.out.println("----------------------------");
        postman.perform(MockMvcRequestBuilders.put("/api/v1/child/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value("edit"))
                .andExpect(jsonPath("$.version").value(1));
        System.out.println("----------------------------");
        ChildDto updated = childService.getChildById(id);
        assertEquals("edit", updated.name());
        assertEquals(1, updated.version());
    }




}