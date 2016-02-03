package edu.bvrcj.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoMain {
   
  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext(DemoJavaConfig.class);
     
    HelloWorldBean helloWorld = ctx.getBean(HelloWorldBean.class);
    System.out.println(helloWorld.sayHello());
  }
}