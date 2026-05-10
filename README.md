# LLM Java Client

Spring Boot API that calls a local LLM using Ollama.

## Flow
User → Controller → Service → OllamaClient → Ollama

## Run Ollama
ollama pull llama3.2
ollama run llama3.2

## Run Spring Boot
mvn spring-boot:run

## Test
POST /api/ask