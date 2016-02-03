package edu.bvrcj.profile;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldBean {
  String name;
   
  public HelloWorldBean(String name) {
    this.name = name;
  }
   
  public String sayHello() {
    return "Hello "+name;
  }
}
