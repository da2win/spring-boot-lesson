package com.da2win.springbootlesson11;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.Future;

/**
 *  生产者测试
 */
public class ProducerTest {

    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();

        properties.setProperty("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", StringSerializer.class);
        properties.put("value.serializer", StringSerializer.class);

        KafkaProducer producer = new KafkaProducer(properties);

        ProducerRecord<String, String> record = new ProducerRecord("sf-3", 0, "message", "okay");

        Future<RecordMetadata> future = producer.send(record);

        if (future.isDone()) {
            RecordMetadata recordMetadata = future.get();
            System.out.println(recordMetadata);
        }
    }
}
