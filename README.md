# Teste Técnico – Sillion

Este projeto é uma solução para o teste técnico da Sillion. 
Consiste em uma aplicação Java (Console) para análise de ocorrências de textos em páginas web.

## 🎯 Descrição do desafio

Desenvolver um projeto **Maven Java** que execute o seguinte fluxo no console:

1. **Entrada de Dados:**
    - Receber uma URL válida digitada ppelo usuário.
    - Receber uma frase composta por *N* palavras digitada pelo usuário.

2. **Processamento:**
    - Acessar a página da web indicada pela URL informada.
    - Extrair o conteúdo textual da página.

3. **Saída de Dados:**
    - Exibir no console o número de vezes que a **frase completa** aparece no texto.
    - Exibir no console o número de vezes que **cada palavra** da frase aparece individualmente.

## 🛠 Requisitos Técnicos

- **Linguagem:** Java
- **Gerenciador de Dependências:** Maven
- **Interface:** Linha de Comando (Console Input/Output)
- **Critérios de Avaliação:**
    - Código limpo e claro (Clean Code)
    - Reutilização de código
    - Testes unitários
    - Boas práticas de desenvolvimento

## 📋 Exemplo de Uso Esperado

**Entrada:**
- **URL:** `https://es.wikipedia.org/wiki/Pir%C3%A1mides_de_Egipto`
- **Frase:** `bloques de piedra`

**Saída no Console:**
```text
“bloques de piedra” ⇒ repete 2 vezes
“bloques” ⇒ repete 7 vezes
“de” ⇒ é repetido 215 vezes
“piedra” ⇒ repete 4 vezes
```