package com.zakat.rabbitproducer;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ServiceFromRabbit {

    private Message thisMessage;

    public void returnMessageToFront(Message message){
        thisMessage = message;

    }

    public Message returnMessageToController(){
        return thisMessage;
    }

    public void makeNullMessage(){
        thisMessage = null;
    }

}
