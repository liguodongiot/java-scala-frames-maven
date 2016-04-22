package application;

/**
 * 1、初始配置
 * Created by liguodong on 2016/3/7.
 */

public class KafkaInit {

    final static String zkConnect = "192.168.101.56:2181,192.168.101.10:2181,192.168.101.71:2181";
    final static String groupId = "group_test";
    final static String topic = "topic_test";
    final static String kafkaServerURL = "192.168.101.56";
    final static int kafkaServerPort = 9092;
    final static int kafkaProducerBufferSize = 64 * 1024;
    final static int connectionTimeOut = 20000;
    final static int reconnectInterval = 10000;
    final static String topic2 = "topic2";
    final static String topic3 = "topic3";
    final static String clientId = "SimpleConsumerDemoClient";

}
