package io.cloud.aws.sqs;

import org.springframework.stereotype.Service;

@Service
public class Consumer {

    //@SqsListener(value="my-first-queue",deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void myConsumer(String message)
    {
        System.out.println("Message received:"+message);
    }
}