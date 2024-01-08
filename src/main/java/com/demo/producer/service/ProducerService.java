package com.demo.producer.service;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.*;

//@Component
public class ProducerService {
    @Autowired
    private ActiveMQConnectionFactory jmsConnectionFactory;
    private final Logger logger = LoggerFactory.getLogger(ProducerService.class);
    public void sendDataToQueue(String data) {

        Connection connection;
        MessageProducer producer;
        Session session;
        Queue queue;
        try {
            connection = jmsConnectionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            queue = session.createQueue("queue1");
            connection.start();
            ObjectMessage objectMessage = session.createObjectMessage();
            producer = session.createProducer(queue);
            objectMessage.setObject(data);
            objectMessage.setStringProperty("JMSXGroupID", data);
            producer.send(objectMessage);

        } catch (Exception e) {
            logger.error("Exception while sending ScrapeInput to on demand queue", e);
        }
    }

}
