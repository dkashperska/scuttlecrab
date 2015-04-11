package org.kashpersky.scuttle;

import org.hibernate.SessionFactory;
import org.kashpersky.scuttle.config.ScuttleCrabConfig;
import org.kashpersky.scuttle.config.data.HibernateConfiguration;
import org.kashpersky.scuttle.config.data.MongoConfiguration;
import org.kashpersky.scuttle.domain.hibernate.Champion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScuttleCrabApp {

   public static void main(String... args) {
       AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ScuttleCrabConfig.class,
               MongoConfiguration.class, HibernateConfiguration.class);
       // insert code here :D
   }

}
