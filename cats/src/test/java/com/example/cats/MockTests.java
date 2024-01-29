package com.example.cats;

import com.example.cats.Exceptions.GlobalExceptionHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class MockTests {
    private MockMvc mockMvc;

    @Mock
    private MyRestService service;

    @InjectMocks
    private MyRestController controller;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(
                new GlobalExceptionHandler(), controller).build();
    }

    @Test
    public void GetByIdReturns200WhenCatExistsTest() throws Exception {
        Cat cat = new Cat(1,"black","John");
        when(service.findCatById(1)).thenReturn(cat);
        mockMvc.perform(MockMvcRequestBuilders.get("/cat/id/1"))
                .andExpect(status().isOk());
    }
}
