package edu.bvrcj.profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
 
@Configuration
public class DemoJavaConfig {
 
  @Value("${hellow.world.name}") String helloWorldName;
 
  @Bean
  public HelloWorldBean helloWorldBean() {
    return new HelloWorldBean(helloWorldName);
  }
   
  /**
   * Add PropertySourcesPlaceholderConfigurer to make placeholder work.
   * This method MUST be static
   */
  @Bean
  public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
    Resource resource = new ClassPathResource("/development.properties");
    String activeProfile;
     
    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer =  new PropertySourcesPlaceholderConfigurer();
     
    // get active profile
    activeProfile = System.getProperty("spring.profiles.active");
 
    // choose different property files for different active profile
    if ("development".equals(activeProfile)) {
      resource = new ClassPathResource("/development.properties");
    } else if ("test".equals(activeProfile)) {
      resource = new ClassPathResource("/test.properties");
    } else {
      resource = new ClassPathResource("/production.properties");
    }
     
    // load the property file
    propertySourcesPlaceholderConfigurer.setLocation(resource);
     
    return propertySourcesPlaceholderConfigurer;
  }
}