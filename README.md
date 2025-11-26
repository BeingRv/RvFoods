# Rv Foods - QR Menu (Demo project)

This is a minimal Spring Boot + MySQL backend with a simple frontend (menu + kitchen dashboard)
for a QR-based restaurant menu and order placement.

**Demo restaurant name:** Rv Foods

## What is included
- Spring Boot project (Maven)
- Entities, Repositories, Controllers (Menu, Order, Admin)
- Simple frontend files in /frontend (menu.html, admin.html)
- schema.sql for MySQL
- Dockerfile and docker-compose.yml
- README

## How to run (local, quick)
1. Install JDK 17 and Maven, and MySQL (or use Docker compose below).
2. Edit `src/main/resources/application.properties` to set your MySQL credentials.
3. Build:
   ```bash
   mvn clean package
   ```
4. Run:
   ```bash
   java -jar target/rvfoods-qrmenu-0.0.1-SNAPSHOT.jar
   ```
5. Open `frontend/menu.html` in a browser (it calls backend at http://localhost:8080).
   Or host frontend static files with any static hosting and ensure backend is reachable.

## Run with Docker (recommended quick start)
```bash
docker-compose up --build
```
This will start MySQL and the Spring Boot app (app connects to db service).

## Important notes
- The frontend is minimal and assumes backend at http://localhost:8080.
- Update `application.properties` or use environment variables when deploying.
- For production, configure proper security, validations, and error handling.

## Next steps you can ask me to do:
- Add JWT-based admin authentication
- Add image upload for menu items
- Add UPI / payment integration
- Provide production deployment on AWS / DigitalOcean
- Provide a printable QR generator for each table

Enjoy! — I can help further with code changes or enhancements.
