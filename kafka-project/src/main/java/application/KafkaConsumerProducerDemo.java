package application;

/**
 * Created by liguodong on 2016/3/7.
 */
public class KafkaConsumerProducerDemo
{
    public static void main(String[] args)
    {
        //生产者
        KafkaProducer producerThread = new KafkaProducer(KafkaInit.topic);
        producerThread.start();

        //消费者
        KafkaConsumer consumerThread = new KafkaConsumer(KafkaInit.topic);
        consumerThread.start();
    }
}