package com.bilgeadam.springboot.beans.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("FORD")
public class Ford implements Car{
    @Override
    public void startEngine() {
        System.out.println("engineen has been started - Ford");
    }
}
