package com.sillion.challenge;

import com.sillion.challenge.exception.ScrapingException;
import com.sillion.challenge.exception.ValidationException;
import com.sillion.challenge.io.ConsoleReader;
import com.sillion.challenge.io.ConsoleWriter;
import com.sillion.challenge.service.ScraperService;
import com.sillion.challenge.service.TextAnalyzerService;

import java.util.Map;

public class Main {

    private final ConsoleReader reader;
    private final ConsoleWriter writer;
    private final ScraperService scraperService;
    private final TextAnalyzerService analyzerService;

    public Main() {
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();
        this.scraperService = new ScraperService();
        this.analyzerService = new TextAnalyzerService();
    }

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        try {
            writer.println("==========================================");
            writer.println("   DESAFIO SILLION - JAVA SCRAPER CLI    ");
            writer.println("==========================================");

            boolean isRunning = true;

            while (isRunning) {
                performAnalysis();

                writer.println("");
                isRunning = reader.readConfirmation(" Deseja realizar outra análise? [S/N]");

                if (isRunning) {
                    writer.printSeparator();
                }
            }

        } catch (Exception e) {
            writer.printError("Fatal Application Error: " + e.getMessage());
        } finally {
            reader.close();
            writer.println("\n Programa encerrado.");
        }
    }

    private void performAnalysis() {
        try {

            writer.printInputPrompt("\n1. Digite a URL:");
            String url = reader.readLine();

            if (url.isEmpty()) {
                writer.printError("A URL não pode estar vazia!");
                return;
            }

            writer.printInputPrompt("2. Digite a Frase:");
            String phrase = reader.readLine();

            if (phrase.isEmpty()) {
                writer.printError("A frase não pode estar vazia!");
                return;
            }

            writer.println("\n Conectando ao site... (Aguarde)");
            String text = scraperService.extractText(url);

            if (text.isEmpty()) {
                writer.printError("O site retornou conteúdo vazio.");
                return;
            }

            writer.printSuccess("Texto extraído (" + text.length() + " caracteres).");

            writer.printSeparator();
            writer.println("RESULTADOS:");

            long phraseCount = analyzerService.countPhraseOccurrences(text, phrase);
            writer.printPhraseResult(phrase, phraseCount);

            Map<String, Long> wordCounts = analyzerService.analyzePhrase(text, phrase);
            writer.printWordResults(wordCounts);

        } catch (ValidationException e) {
            writer.printError(e.getMessage());
        } catch (ScrapingException e) {

            writer.printError(e.getMessage());
        } catch (Exception e) {
            writer.printError("Erro inesperado: " + e.getMessage());
        }
    }
}