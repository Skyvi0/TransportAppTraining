package j.kurs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App {

    private static Transportierbar tisch;
    private static Transportierbar stuhl;

    public static void main(String[] args) {
        //Logger
        Logger logger = LoggerFactory.getLogger(App.class);
        // create a new inventory with a maximum of 10 items
        Inventory inventory = new Inventory(10);
        inventory.add(tisch);
        inventory.add(new Tisch(20, false));
        inventory.add(new Tisch(30, true));
        inventory.add(new Stuhl(10, false));
        inventory.add(new Stuhl(15, true));
        inventory.add(new Stuhl(20, false));
        inventory.add(new Stuhl(25, true));

        // remove item from the inventory
        inventory.remove(tisch);
        inventory.remove(stuhl);

        // get the total weight of the inventory
        Transportierbar glasTisch = new Tisch(30, true);
        logger.info("Das Gewicht des Tisches ist: " + glasTisch.gewicht() + "kg" + " und zerbrechlich: "
                + glasTisch.zerbrechlich());
        logger.info("Total weight: " + inventory.totalWeight());

       
        // impliment a connection to the oracle database
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            logger.error("Oracle JDBC Driver not found", e);
        }
        logger.info("Oracle JDBC Driver registered");
        

        // check if the inventory is zerbrechlich if so wrap it in some bubble wrap
        if (inventory.zerbrechlich()) {
            BubbleWrap bubbleWrap = new BubbleWrap();
            for (int i = 0; i < inventory.countAdequateItems(); i++) {
                bubbleWrap.wrap(inventory.getItems()[i]);
            }
            logger.info("fragile items wrapped in bubble wrap");
        }

        // create a new employee
        Employee employee = new Employee("John", "Doe", 1, "Employee");
        logger.info("First name: " + employee.getFirstName() + " Last name: " + employee.getLastName() + " Security id: "
                + employee.getSecurityId() + " Role: " + employee.getRole());

        // create a new company
        Company company = new Company();
        company.add(employee);
        logger.info("New employee added to the company");

        // create a new warehouse and add the inventory to it
        Warehouse warehouse = new Warehouse(0, null, null);
        warehouse.add(inventory);
        logger.info("New inventory added to the warehouse");

        // create a new transport crew and add the warehouse to it
        TransportCrew transportCrew = new TransportCrew(1, warehouse);
        logger.info("New warehouse added to the transport crew");

        // transport the inventory to the warehouse
        transportCrew.transport(inventory);
        logger.info("Inventory transported to the warehouse");

    }

    // add employee to the company and give them a unique security id the id goes from 1-5 and is used to check if they have access to that area
    public static void addEmployee(Company company, Employee employee, int id) {
        company.addEmployee(employee, id);
    }

    // add an item to the inventory
    public static void add(Inventory inventory, Transportierbar item) {
        inventory.add(item);

    }

    // remove an item from the inventory
    public static void remove(Inventory inventory, Transportierbar item) {
        inventory.remove(item);

    }

    // get the total weight of the inventory
    public static float totalWeight(Inventory inventory) {
        return inventory.totalWeight();
    }

}
