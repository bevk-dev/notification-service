# notification-service

Kratek opis
- Upravljanje obvestil. Povezan s Kafko za dogodke, lahko kliče zunanje SMTP ali push providerje.

Gradnja

```bash
# v mapi notification-service
./mvnw clean package -DskipTests
docker build -t <your-registry>/notification-service:latest .
```

Zagon
- Lokalno z Docker Compose: `shopsync-infra/docker-compose.yml` (običajno ni izpostavljenih host portov).
- Kubernetes manifests: `shopsync-infra/k8s/notification-service`.

env spremenljivke
- `SPRING_KAFKA_BOOTSTRAP_SERVERS` — Kafka bootstrap server.
- SMTP/Push nastavitve (odvisno od implementacije) — preverite `application.yml`.

Konfiguracija
- `src/main/resources/application.yml` ali `application.properties`
