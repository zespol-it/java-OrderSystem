# OrderSystem – Leroy Merlin (Spring Boot + Angular)

Aplikacja do zarządzania zamówieniami i rezerwacjami produktów dla Leroy Merlin.

## Wymagania
- Java 17+
- Maven
- PostgreSQL (domyślnie: baza `ordersystem`, użytkownik `postgres`, hasło `postgres`)
- Node.js + npm (dla frontendu Angular)

## Backend (Spring Boot)

1. **Utwórz bazę danych PostgreSQL:**
   ```sh
   createdb -U postgres ordersystem
   # lub przez psql:
   # CREATE DATABASE ordersystem;
   ```

2. **Zbuduj projekt i pobierz zależności:**
   ```sh
   cd ordersystem
   mvn clean install
   ```

3. **Uruchom aplikację:**
   ```sh
   mvn spring-boot:run
   ```

4. **Aplikacja będzie dostępna pod adresem:**
   - http://localhost:8080
   - Dokumentacja Swagger: http://localhost:8080/swagger-ui.html

5. **Przykładowe dane:**
   - Przy starcie aplikacji ładowane jest 10 zamówień dla użytkownika `user`.
   - Przykładowe produkty: P001, P002, P003.

## Frontend (Angular)

1. **Instalacja zależności:**
   ```sh
   cd frontend
   npm install
   ```

2. **Uruchom aplikację Angular:**
   ```sh
   npx ng serve --open
   ```
   - Aplikacja będzie dostępna pod adresem: http://localhost:4200/

## API
- **GET /api/orders** – lista zamówień
- **GET /api/orders/{id}** – szczegóły zamówienia
- **POST /api/orders** – utworzenie zamówienia

## CORS i bezpieczeństwo
- CORS jest skonfigurowany dla połączenia z Angulara (`localhost:4200`).
- Endpointy `/api/**` są dostępne bez logowania (na czas developmentu).

## Testy
- Backend: JUnit (testy jednostkowe i integracyjne)
- Frontend: Jasmine + Karma (testy komponentów Angular)

## Autor
- Projekt demonstracyjny na potrzeby rekrutacji / portfolio.

## Dane logowania (domyślne Spring Security)
- **Login:** `user`
- **Hasło:** generowane przy starcie aplikacji, szukaj w logach:
  ```
  Using generated security password: <hasło>
  ```

## Typowe problemy
- **Błąd pluginu spring-boot:** Upewnij się, że jesteś w katalogu `ordersystem`.
- **Błąd bazy danych:** Upewnij się, że baza `ordersystem` istnieje i dane logowania są poprawne.
- **Dane logowania:** Hasło do panelu Swagger/API generowane jest przy każdym starcie aplikacji.

## Wyłączenie zabezpieczeń (na czas developmentu)
Aby wyłączyć logowanie do API, dodaj prostą konfigurację Security w projekcie lub napisz do autora.

---

Projekt demonstracyjny – do rozbudowy według potrzeb biznesowych Leroy Merlin. 