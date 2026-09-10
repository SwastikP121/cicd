package com.example.web;

public class GreetingService {
    public String greetingFor(String name) {
        String trimmedName = name == null ? "" : name.trim();
        return trimmedName.isEmpty() ? "Hello, World!" : "Hello, " + trimmedName + "!";
    }
}
