package com.demo.producer;

import com.demo.producer.service.ProducerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class ProducerApplicationTests {

	@Autowired
	private ProducerService producerService;

	@Test
	public void testSendDataToQueue() throws InterruptedException {
		Random random = new Random();

//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 15; j++) {
//				String randValue = String.valueOf(j);
//				Thread.sleep(1000);
//				System.out.println(randValue);
//				producerService.sendDataToQueue(randValue);
//			}
//		}
//		for (int i = 0; i < 100; i++) {
//			producerService.sendDataToQueue("16");
//		}
		for (int i = 0; i < 100; i++) {
			producerService.sendDataToQueue("18");
		}
		for (int i = 0; i < 10; i++) {
			producerService.sendDataToQueue("19");
		}
	}

}
