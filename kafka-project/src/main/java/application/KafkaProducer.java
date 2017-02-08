package application;



import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;


import java.util.Properties;

/**
 * 2.生产者
 * bin/kafka-console-producer.sh
 * --broker-list 192.168.101.56:9092,192.168.101.10:9092,192.168.101.71:9092
 * --topic mykafka
 *
 * Created by liguodong on 2016/3/7.
 */

public class KafkaProducer extends Thread
{
    private final kafka.javaapi.producer.Producer<Integer, String> producer;
    private final String topic;
    private final Properties props = new Properties();

    public KafkaProducer(String topic)
    {
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("metadata.broker.list", "192.168.101.56:9092,192.168.101.10:9092,192.168.101.71:9092");


        producer = new kafka.javaapi.producer.Producer<Integer, String>
                (new ProducerConfig(props));
        this.topic = topic;
    }

    @Override
    public void run() {
        int messageNo = 1;
        while (true)
        {
            String messageStr = new String("Message_" + messageNo);
            System.out.println("Send:" + messageStr);

            //发送数据
            producer.send(new KeyedMessage<Integer, String>(topic, messageStr));
            messageNo++;
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
