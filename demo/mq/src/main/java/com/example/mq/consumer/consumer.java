package com.example.mq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;

public class consumer {

    public static void main(String[] args) throws InterruptedException, MQClientException {

        // Instantiate with specified consumer group name.
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("please_rename_unique_group_name");

        // Specify name server addresses.
        consumer.setNamesrvAddr("localhost:9876");

        // Subscribe one more more topics to consume.
        consumer.subscribe("TopicTest", "*");
        // Register callback to execute on arrival of messages fetched from brokers.

        consumer.registerMessageListener((MessageListenerOrderly) (list, consumeOrderlyContext) -> {
            System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), list);
//            for (MessageExt messageExt : list) {
//
//                System.out.println(new String(messageExt.getBody()));
//            }
            return ConsumeOrderlyStatus.SUCCESS;
        });
        //多线程无顺序消费
//        consumer.registerMessageListener(new MessageListenerConcurrently() {
//
//            @Override
//            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
//                                                            ConsumeConcurrentlyContext context) {
//                for (MessageExt msg : msgs) {
////                    System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
//                    System.out.println(new String(msg.getBody()));
//                }
//                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//            }
//        });

        //Launch the consumer instance.
        consumer.start();

        System.out.printf("Consumer Started.%n");
    }
}
