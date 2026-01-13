package com.shopsync.notification_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;      
import org.springframework.kafka.test.context.EmbeddedKafka;

@SpringBootTest
@ActiveProfiles("test")
@EmbeddedKafka(
    partitions = 1, 
    bootstrapServersProperty = "spring.kafka.bootstrap-servers" // Samodejno poveže vrata s Springom
)
class NotificationServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
