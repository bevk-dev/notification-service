package com.shopsync.notification_service.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @KafkaListener(topics = "notification-events", groupId = "notification-group")
    public void handleNotification(String message) {
        System.out.println("\n[KAFKA MESSAGE RECEIVED]");

        try {
            String[] parts = message.split("\\|");
            String eventType = parts[0];

            switch (eventType) {
                case "LIST_SHARED":
                    // Format: LIST_SHARED|ownerId|friendId|listId
                    System.out.println("🔔 OBVESTILO: Uporabnik " + parts[1] +
                            " je s tabo (" + parts[2] + ") delil seznam ID: " + parts[3]);
                    break;

                case "ITEM_ADDED":
                    // Format: ITEM_ADDED|ownerId|listId|itemName
                    System.out.println("🛒 NOVI ARTIKEL: Na seznamu " + parts[2] +
                            " je bil dodan artikel: " + parts[3]);
                    break;

                default:
                    System.out.println("📩 Prejeto neznano sporočilo: " + message);
            }
        } catch (Exception e) {
            System.err.println("❌ Napaka pri branju sporočila: " + e.getMessage());
        }
    }

    @KafkaListener(topics = {"notification-events", "recipe-events"}, groupId = "notification-group")
    public void consume(String message) {
        String[] parts = message.split("\\|");
        String type = parts[0];

        if ("RECIPE_IMPORTED".equals(type)) {
            String user = parts[1];
            String recipeName = parts[2];
            System.out.println("🔔 [RECIPE SERVICE] Uporabnik " + user + " je uvozil recept: " + recipeName);
        } else if ("LIST_SHARED".equals(type)) {
            // ... tvoja obstoječa koda za deljenje seznama ...
        }
    }
}