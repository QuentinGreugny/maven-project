package com.example;

/**
 * This is a class.
 */
public class Greeter {
  
  private int numero;

  /**
   * This is a constructor.
   */
  public Greeter() {

  }

 /**
 @param someone the name of a person
 @return greeting string
 */
  public String greet(final String someone) {
    return String.format("Hello, %s!", someone);
  }
}

