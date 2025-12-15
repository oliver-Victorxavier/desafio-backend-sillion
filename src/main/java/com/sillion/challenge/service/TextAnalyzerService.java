package com.sillion.challenge.service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextAnalyzerService {

    public long countPhraseOccurrences(String text, String phrase) {
        if (text == null || text.isBlank() || phrase == null || phrase.isBlank()) {
            return 0;
        }

        String regex = "(?i)(?U)\\b" + Pattern.quote(phrase.trim()) + "\\b";

        Matcher matcher = Pattern.compile(regex).matcher(text);

        long count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public Map<String, Long> analyzePhrase(String text, String phrase) {
        Map<String, Long> result = new LinkedHashMap<>();

        if (text == null || text.isBlank() || phrase == null || phrase.isBlank()) {
            return result;
        }

        String[] words = phrase.trim().split("\\s+");

        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z0-9À-ÿ\\-]", "").toLowerCase();

            if (!cleanWord.isEmpty()) {
                long count = countPhraseOccurrences(text, cleanWord);
                result.put(cleanWord, count);
            }
        }
        return result;
    }
}