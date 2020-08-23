package com.example.mq.product;

import com.example.mq.util.ListUtil;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.ArrayList;
import java.util.List;

public class pro {
    public static void main(String[] args) throws Exception {
        //Instantiate with a producer group name.
        DefaultMQProducer producer = new
                DefaultMQProducer("please_rename_unique_group_name");
        // Specify name server addresses.
        producer.setNamesrvAddr("localhost:9876");
        //Launch the instance.
        producer.start();
        //批量发送
        List<Message> messages = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("TopicTest",
                    "TagA",
                    ("Hello RocketMQ " +
                            i).getBytes(RemotingHelper.DEFAULT_CHARSET) //* Message body *//*
            );
            messages.add(msg);
        }
        ListUtil listUtil = new ListUtil(messages);
        while (listUtil.hasNext()) {
            try {
                List<Message> listItem = listUtil.next();
                producer.send(listItem);
            } catch (Exception e) {
                e.printStackTrace();
                //handle the error
            }
        }
        //延迟消费
//        for (int i = 0; i < 1; i++) {
//            //Create a message instance, specifying topic, tag and message body.
//            Message msg = new Message("TopicTest" ,
//                    "TagA" ,
//                    ("Hello RocketMQ " +
//                            i).getBytes(RemotingHelper.DEFAULT_CHARSET) //* Message body *//*
//            );
//            msg.setDelayTimeLevel(3);
//            //Call send message to deliver message to one of brokers.
//            SendResult sendResult = producer.send(msg,new SelectMessageQueueByHash(),"1");
//            System.out.printf("%s%n", sendResult);
//        }
//        for (int i = 0; i < 50; i++) {
//            //Create a message instance, specifying topic, tag and message body.
//            Message msg = new Message("TopicTest" ,
//                    "TagA" ,
//                    ("Hello RocketMQ " +
//                            i).getBytes(RemotingHelper.DEFAULT_CHARSET) //* Message body *//*
//            );
//            //Call send message to deliver message to one of brokers.
//            SendResult sendResult = producer.send(msg,new SelectMessageQueueByHash(),"1");
//            System.out.printf("%s%n", sendResult);
//        }
//        for (int i = 50; i < 100; i++) {
//            //Create a message instance, specifying topic, tag and message body.
//            Message msg = new Message("TopicTest",
//                    "TagB",
//                    ("Hello RocketMQ " +
//                            i).getBytes(RemotingHelper.DEFAULT_CHARSET)
//            );
//            //Call send message to deliver message to one of brokers.
//            SendResult sendResult = producer.send(msg,new SelectMessageQueueByHash(),"2");
//            System.out.printf("%s%n", sendResult);
//        }
/*        for (int i = 0; i < 10; i++) {
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("TopicTest",
                    "TagA" ,
                    ("Hello RocketMQ " +
                            i).getBytes(RemotingHelper.DEFAULT_CHARSET)
            );
            //Call send message to deliver message to one of brokers.
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }*/
        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }
}
