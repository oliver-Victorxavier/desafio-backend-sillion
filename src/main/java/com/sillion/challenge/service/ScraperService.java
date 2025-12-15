package com.sillion.challenge.service;

import com.sillion.challenge.exception.ScrapingException;
import com.sillion.challenge.exception.ValidationException;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.SocketTimeoutException;

public class ScraperService {

    private static final int TIMEOUT_MS = 8000;
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36";

    public String extractText(String url) {
        if (!isValidUrl(url)) {
            throw new ValidationException("URL inválida: Verifique se incluiu http:// ou https://");
        }

        try {
            return Jsoup.connect(url)
                    .userAgent(USER_AGENT)
                    .timeout(TIMEOUT_MS)
                    .get()
                    .text();

        } catch (SocketTimeoutException e) {
            throw new ScrapingException("O site demorou muito para responder (> 8s). Tente outra URL.");
        } catch (IOException e) {
            throw new ScrapingException("Falha de conexão com o site: " + e.getMessage(), e);
        }
    }

    public boolean isValidUrl(String url) {
        return url != null &&
                !url.trim().isEmpty() &&
                (url.startsWith("http://") || url.startsWith("https://"));
    }

}