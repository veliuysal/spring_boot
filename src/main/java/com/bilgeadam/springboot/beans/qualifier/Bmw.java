package com.bilgeadam.springboot.beans.qualifier;

import org.springframework.stereotype.Component;

@Component
public class Bmw implements Car {
    @Override
    public void startEngine() {
        System.out.println("engineen has been started - Bmw");
    }
}
