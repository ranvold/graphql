package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphQLServer {

  public static void main(String[] args) {
    DBManager.getInstance();
    SpringApplication.run(GraphQLServer.class,args);
  }
}