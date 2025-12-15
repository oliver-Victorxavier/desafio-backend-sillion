package com.sillion.challenge.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TextAnalyzerServiceTest {

    private TextAnalyzerService analyzer;

    @BeforeEach
    void setUp() {
        analyzer = new TextAnalyzerService();
    }

    @Test
    @DisplayName("Should preserve words with hyphens")
    void shouldPreserveHyphens() {
        String text = "The back-end is Java and the front-end is Angular.";
        String phrase = "back-end";

        long count = analyzer.countPhraseOccurrences(text, phrase);

        assertEquals(1, count, "Should not split hyphenated words");
    }

    @Test
    @DisplayName("Should handle multiple spaces in input phrase")
    void shouldHandleMultipleSpacesInPhrase() {
        String text = "Java is cool and Java is robust";
        String phrase = "Java    is";

        Map<String, Long> result = analyzer.analyzePhrase(text, phrase);

        assertEquals(2, result.get("java"));
        assertEquals(2, result.get("is"));
    }

    @Test
    @DisplayName("Should maintain word order in Map (LinkedHashMap)")
    void shouldMaintainWordOrder() {
        String text = "one two three";
        String phrase = "one two three";

        Map<String, Long> result = analyzer.analyzePhrase(text, phrase);

        String[] expectedKeys = {"one", "two", "three"};
        String[] actualKeys = result.keySet().toArray(new String[0]);

        assertArrayEquals(expectedKeys, actualKeys, "Insertion order must be preserved");
    }

    @Test
    @DisplayName("Should count exact phrase case insensitive")
    void shouldCountExactPhraseCaseInsensitive() {
        String text = "The Rat gnawed the clothes of the king of Rome.";
        assertEquals(1, analyzer.countPhraseOccurrences(text, "king of rome"));
    }
}