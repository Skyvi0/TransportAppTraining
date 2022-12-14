package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


//@EntityScan( basePackages = {"com.example.demo"})
// fixed Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		Logger logger = LoggerFactory.getLogger(DemoApplication.class);  
        // impliment a connection to the oracle database
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            logger.error("Oracle JDBC Driver not found", e);
        }
        logger.info("Oracle JDBC Driver registered");
        
        
		// read the database using hibernate store the values
		
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            // braking point of the application right now
            Inventory inventory = new Inventory(1L, true, 1.0f, "2021-05-01", "test");
            session.persist(inventory);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.error("Data not saved", e);
        }
	
	}

}
