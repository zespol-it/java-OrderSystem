# OrderSystem – Leroy Merlin (Spring Boot)

Aplikacja do zarządzania zamówieniami i rezerwacjami produktów dla Leroy Merlin.

## Wymagania
- Java 17+
- Maven
- PostgreSQL (domyślnie: baza `ordersystem`, użytkownik `postgres`, hasło `postgres`)

## Uruchomienie

1. **Utwórz bazę danych PostgreSQL:**
   ```sh
   createdb -U postgres ordersystem
   # lub przez psql:
   # CREATE DATABASE ordersystem;
   ```

2. **Zbuduj projekt i pobierz zależności:**
   ```sh
   mvn clean install
   ```

3. **Uruchom aplikację:**
   ```sh
   mvn spring-boot:run
   ```

4. **Aplikacja będzie dostępna pod adresem:**
   - http://localhost:8080
   - Dokumentacja Swagger: http://localhost:8080/swagger-ui.html

## Dane logowania (domyślne Spring Security)
- **Login:** `user`
- **Hasło:** generowane przy starcie aplikacji, szukaj w logach:
  ```
  Using generated security password: <hasło>
  ```

## API
- Tworzenie zamówienia: `POST /api/orders`
- Zmiana statusu zamówienia: `POST /api/orders/{orderId}/status`
- Pobieranie zamówienia: `GET /api/orders/{orderId}`
- (Możesz dodać kolejne endpointy np. do produktów)

## Typowe problemy
- **Błąd pluginu spring-boot:** Upewnij się, że jesteś w katalogu `ordersystem`.
- **Błąd bazy danych:** Upewnij się, że baza `ordersystem` istnieje i dane logowania są poprawne.
- **Dane logowania:** Hasło do panelu Swagger/API generowane jest przy każdym starcie aplikacji.

## Wyłączenie zabezpieczeń (na czas developmentu)
Aby wyłączyć logowanie do API, dodaj prostą konfigurację Security w projekcie lub napisz do autora.

---

Projekt demonstracyjny – do rozbudowy według potrzeb biznesowych Leroy Merlin. 