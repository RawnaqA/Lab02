package com.example.junit.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class MessageServiceTest {
    private final MessageService service =new MessageService();

    @DisplayName("Testing MessageService.getAll()")
    @Test

    void getAll() {

        Integer actual = 100;
        Integer expected = service.getAll().size();
        assertEquals(expected, actual);
    }
    @DisplayName("Testing MessageService.getByFrom()")
    @Test
    void shouldFailWhenFromIsNull() {

        String mock1 = "Message: {" + "\n" +
                "From: " + "F1" + "\n" +
                "To: " + "T1" + "\n" +
                "Header: " + "H1" + "\n" +
                "Body" + "B1" + "\n" + "}";

        Executable instruction = () -> {
            service.getByFrom(mock1);
        };
        assertThrows(IllegalArgumentException.class, instruction);
    }

    @DisplayName("Testing MessageService.getByTo()")
    @Test
    void shouldThrowExWhenToIsNull() {

        String mock1 = "Message: {" + "\n" +
                "From: " + "F1" + "\n" +
                "To: " + "T1" + "\n" +
                "Header: " + "H1" + "\n" +
                "Body" + "B1" + "\n" + "}";

        Executable instruction = () -> {
            service.getByTo("@null");
        };
        assertThrows(IllegalArgumentException.class, instruction);
    }


}