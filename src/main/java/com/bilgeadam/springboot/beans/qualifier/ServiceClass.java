package com.bilgeadam.springboot.beans.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ServiceClass {

    @Autowired
    @Qualifier("FORD")
    private Car car;
}
