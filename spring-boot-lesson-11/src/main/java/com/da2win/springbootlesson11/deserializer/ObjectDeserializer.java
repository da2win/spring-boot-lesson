package com.da2win.springbootlesson11.deserializer;

import org.apache.kafka.common.serialization.Deserializer;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

/**
 * 用户的反序列化器
 */
public class ObjectDeserializer implements Deserializer<Object> {
    @Override
    public void configure(Map configs, boolean isKey) {

    }

    @Override
    public Object deserialize(String topic, byte[] data) {
        Object object = null;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            object = objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("topic : " + topic + ", Deserialized object : " + byteArrayInputStream);
        return object;
    }

    @Override
    public void close() {

    }
}
