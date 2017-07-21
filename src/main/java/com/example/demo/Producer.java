package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * Created by clb on 17-7-4.
 */
@Component
@EnableScheduling
public class Producer {
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;//使用JmsMessagingTemplate将消息放入队列

	@Autowired
	private Queue queue;

	@Scheduled(fixedDelay = 5000)//每3s执行1次,将消息放入队列内
	public void send() {
		this.jmsMessagingTemplate.convertAndSend(this.queue, "测试消息队列"+System.currentTimeMillis()/1000);
	}
}
