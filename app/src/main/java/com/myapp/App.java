package com.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(basePackages = "com.myapp",
    includeFilters = @ComponentScan.Filter(
        type = FilterType.ANNOTATION, classes = DomainComponent.class
    ))
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}