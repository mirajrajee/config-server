package com.howtodoinjava.example.springconfigclient;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;


@ConfigurationProperties
public class APConfig {
  private Map<String, Map<String,String>> greatings;

  public Map<String, Map<String, String>> getGreatings() {
    return greatings;
  }

  public void setGreatings(Map<String, Map<String, String>> greatings) {
    this.greatings = greatings;
  }
}
