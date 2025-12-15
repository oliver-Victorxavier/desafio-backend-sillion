package com.sillion.challenge.service;

import com.sillion.challenge.exception.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScraperServiceTest {

    private ScraperService scraper;

    @BeforeEach
    void setUp() {
        scraper = new ScraperService();
    }

    @Test
    @DisplayName("Should validate correct URLs")
    void shouldAcceptValidUrl() {
        assertTrue(scraper.isValidUrl("https://www.google.com"));
        assertTrue(scraper.isValidUrl("http://example.com"));
    }

    @Test
    @DisplayName("Should reject invalid URLs (Pure logic)")
    void shouldRejectInvalidUrl() {
        assertFalse(scraper.isValidUrl("ftp://invalid.com"));
        assertFalse(scraper.isValidUrl("www.google.com"));
        assertFalse(scraper.isValidUrl(""));
        assertFalse(scraper.isValidUrl(null));
    }

    @Test
    @DisplayName("Should throw Exception when attempting to extract invalid URL")
    void shouldThrowErrorWhenExtractingInvalidUrl() {
        assertThrows(ValidationException.class, () -> {
            scraper.extractText("invalid-url");
        });
    }
}