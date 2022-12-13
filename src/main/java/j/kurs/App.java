package j.kurs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App {

    public static void main(String[] args) {
        //Logger
        Logger logger = LoggerFactory.getLogger(App.class);
        // create a new inventory with a maximum of 10 items
       
        // impliment a connection to the oracle database
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            logger.error("Oracle JDBC Driver not found", e);
        }
        logger.info("Oracle JDBC Driver registered");
        
        
        // read the database using hibernate store the values in an array list
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
