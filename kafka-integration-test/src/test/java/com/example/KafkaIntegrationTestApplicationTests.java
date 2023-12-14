package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.ActiveProfiles;

import com.example.service.KafkaListenerService;
import com.example.service.KafkaProducerService;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@EmbeddedKafka(topics= {"integration-topic"},brokerProperties= {"listeners=PLAINTEXT://localhost:9092","port=9092"})
@ActiveProfiles("test")
class KafkaIntegrationTestApplicationTests {
	@Autowired private KafkaProducerService kafkaProducerService;
	@Autowired private KafkaListenerService kafkaListenerService;
	
	@Test
	void test1() throws Exception {
		kafkaProducerService.sendMessage("message A");
		kafkaListenerService.getBarrier().await();
		assertNotNull(kafkaListenerService.getMessage());
		assertEquals("message A",kafkaListenerService.getMessage());
	}

}
