package com.sillion.challenge.service;

import org.jsoup.Jsoup;
import java.io.IOException;

public class ScraperService {
    public String extractText(String url) {
        try {
            if (url == null || !url.startsWith("http")) {
                throw new IllegalArgumentException("URL inválida.");
            }
            return Jsoup.connect(url).userAgent("Mozilla/5.0").get().text();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao conectar: " + e.getMessage());
        }
    }
}