package com.example.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by clb on 17-7-4.
 */
@Component
public class Consumer {
	/**使用@JmsListener注解来监听指定的某个队列内的消息,是否有新增,有的话则取出队列内消息
	 *进行处理
	 **/
//	@JmsListener(destination="${queue111}")
//	public void removeMessage(Map message){
//		System.out.println("监听接收到的消息是:"+message);//打印队列内的消息
//	}
	@JmsListener(destination="${queue}")
	public void receive(String message){
		System.out.println("监听接收到的消息是:"+message);//打印队列内的消息
	}
}
