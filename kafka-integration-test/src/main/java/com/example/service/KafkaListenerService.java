package com.example.service;

import java.util.concurrent.CyclicBarrier;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerService {
	private CyclicBarrier barrier = new CyclicBarrier(2);
	private String message;

	@KafkaListener(topics = "integration-topic")
	public void listen(String message) throws Exception {
		System.err.println(message);
		this.message = message;
		barrier.await();
	}

	public String getMessage() {
		return message;
	}

	public CyclicBarrier getBarrier() {
		return barrier;
	}

}
