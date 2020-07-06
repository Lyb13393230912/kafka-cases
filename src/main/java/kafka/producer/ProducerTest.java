package kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.UUID;

/**
 * @ClassName ProducerTest
 * @Description: 生产者
 * @Author Lyb
 * @Date 2020/7/6
 **/
public class ProducerTest {
    public static void main(String[] args) {
        Properties prop = new Properties();
        prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.24.11:9092");
        prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);

        KafkaProducer<String,String> producer = new KafkaProducer<>(prop);

        ProducerRecord<String, String> record = new ProducerRecord<>("testTopic", UUID.randomUUID().toString(),"Hello Kafka");

        producer.send(record);

        //4. 释放资源
        producer.flush();
        producer.close();
    }
}
