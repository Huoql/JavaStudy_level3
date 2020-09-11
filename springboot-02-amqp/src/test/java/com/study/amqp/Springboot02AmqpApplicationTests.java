package com.study.amqp;

import com.rabbitmq.client.AMQP;
import com.study.amqp.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class Springboot02AmqpApplicationTests {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	AmqpAdmin amqpAdmin;

	@Test
	public void createAmqp() {
		amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange"));

		amqpAdmin.declareQueue(new Queue("amqpAdmin.queue"));

		//创建绑定规则
		amqpAdmin.declareBinding(new Binding("amqpAdmin.queue",Binding.DestinationType.QUEUE,
				"amqpAdmin.exchange","amqpAdmin.routingKey",null));
	}

	/**
	 * 1.单播（点对点模式）
	 */
	@Test
	void contextLoads() {
		//需要自己构造一个message，定义消息体内容和消息头
//		rabbitTemplate.send(exchange,routeKey,message);

		Map<String,Object> map = new HashMap<String ,Object>();
		map.put("msg","这是第一条消息");
		//object默认被当做消息体，只需要传入要发送的对象，自动序列化（采用的是java默认的序列化方式）发送给rabbitmq
//		rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
		rabbitTemplate.convertAndSend("exchange.direct","study.news",new Book("西游记","吴承恩"));
	}

	@Test
	public void receive() {
		Object o = rabbitTemplate.receiveAndConvert("study.news");
		System.out.println(o.getClass());
		System.out.println(o);
	}

}
