package com.example.web;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingServiceTest {
    private final GreetingService greetingService = new GreetingService();

    @Test
    void usesWorldWhenNameIsMissing() {
        assertEquals("Hello, World!", greetingService.greetingFor(null));
    }
}
