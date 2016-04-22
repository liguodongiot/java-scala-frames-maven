package demos;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import kafka.serializer.StringEncoder;




/**
 * 发送数据
 * 发送了: 0
 * 发送了: 1
 * 发送了: 2
 * 发送了: 3
 * 发送了: 4
 * Created by liguodong on 2016/3/6.
 */

public class kafkaProducer extends Thread{

    private String topic;

    public kafkaProducer(String topic){
        super();
        this.topic = topic;
    }


    @Override
    public void run() {
        Producer producer = createProducer();
        int i=0;
        while(true){
            producer.send(new KeyedMessage<Integer, String>(topic, "message: " + i));
            System.out.println("发送了: " + i);
            try {
                TimeUnit.SECONDS.sleep(1);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Producer createProducer() {
        Properties properties = new Properties();
        properties.put("zookeeper.connect", "192.168.1.110:2181,192.168.1.111:2181,192.168.1.112:2181");//声明zk
        properties.put("serializer.class", StringEncoder.class.getName());
        properties.put("metadata.broker.list", "192.168.1.110:9092,192.168.1.111:9093,192.168.1.112:9094");// 声明kafka broker
        return new Producer<Integer, String>(new ProducerConfig(properties));
    }


    public static void main(String[] args) {
        new kafkaProducer("test").start();// 使用kafka集群中创建好的主题 test

    }

}
