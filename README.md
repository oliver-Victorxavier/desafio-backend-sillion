# Teste Técnico – Sillion

Este projeto é uma solução para o teste técnico da Sillion. 
Consiste em uma aplicação Java (Console) para análise de ocorrências de textos em páginas web.

## 🎯 Descrição do desafio

Desenvolver um projeto **Maven Java** que execute o seguinte fluxo no console:

1. **Entrada de Dados:**
   - Receber uma URL válida digitada pelo usuário. 
   - Receber uma frase composta por *N* palavras digitada pelo usuário. 

2. **Processamento:**
   - Acessar a página da web indicada pela URL informada.
   - Extrair o conteúdo textual da página.

3. **Saída de Dados:**
   - Exibir no console o número de vezes que a **frase completa** aparece no texto. 
   - Exibir no console o número de vezes que **cada palavra** da frase aparece individualmente.

# Exemplo de Execução - Desafio Sillion

## Saída no Console (Execução Real)

```
==========================================
   DESAFIO SILLION - JAVA SCRAPER CLI    
==========================================

1. Digite a URL: 
> https://es.wikipedia.org/wiki/Pir%C3%A1mides_de_Egipto

2. Digite a Frase: 
> bloques de piedra

⏳ Conectando ao site... (Aguarde)
✅ Texto extraído (16213 caracteres).
--------------------------------------------------
📊 RESULTADOS:
"bloques de piedra" ⇒ repete 2 vezes
"bloques" ⇒ repete 7 vezes
"de" ⇒ repete 194 vezes
"piedra" ⇒ repete 4 vezes
```

> **Nota:** Resultados obtidos em 14/12/2025. Os valores podem variar conforme atualizações na página da Wikipédia. 

## Análise dos Resultados

- **Frase completa:** "bloques de piedra" encontrada 2 vezes no texto
- **Palavras individuais:** Cada palavra analisada separadamente
- **Case insensitive:** Busca ignora maiúsculas/minúsculas
- **Word boundaries:** Respeita fronteiras de palavras (não conta parciais)
- **Encoding:** Suporte completo a acentos e caracteres especiais
- 
## 🛠 Requisitos Técnicos

- **Linguagem:** Java 21
- **Gerenciador de Dependências:** Maven
- **Interface:** Linha de Comando (Console Input/Output)
- **Critérios de Avaliação:**
  - Código limpo e claro (Clean Code)
  - Reutilização de código
  - Testes unitários
  - Boas práticas de desenvolvimento

## 🐳 Como Executar com Docker 

O projeto utiliza **Multi-stage build**, permitindo a execução sem necessidade de instalar Java ou Maven na máquina local.

1. **Construir a imagem:**
   ```bash
   docker build -t sillion-challenge .
   ```

2. **Rodar a aplicação:**
   (As flags `-i` e `-t` são obrigatórias para permitir a entrada de dados no console)
   ```bash
   docker run -it sillion-challenge
   ```

## 💻 Como Executar Localmente

Caso prefira rodar diretamente via JDK e Maven:

1. **Compilar e gerar o JAR:**
   ```bash
   mvn clean package
   ```

2. **Executar:**
   ```bash
   java -jar target/challenge-0.0.1-SNAPSHOT.jar
   ```

## 🧪 Rodar Testes Unitários

```bash
mvn clean test
```
