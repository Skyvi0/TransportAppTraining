package j.kurs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    public static void main(String[] args) {
        //Logger
        Logger logger = LoggerFactory.getLogger(App.class);
        // create a new inventory with a maximum of 10 items
        Inventory inventory = new Inventory(10);
        Tisch tisch = new Tisch(10, true);
        inventory.add(tisch);
        inventory.add(new Tisch(20, false));
        inventory.add(new Tisch(30, true));

        // remove item from the inventory
        inventory.remove(tisch);

        // get the total weight of the inventory
        Transportierbar glasTisch = new Tisch(30, true);
        logger.info("Das Gewicht des Tisches ist: " + glasTisch.gewicht() + "kg" + " und zerbrechlich: "
                + glasTisch.zerbrechlich());
        logger.info("Total weight: " + inventory.totalWeight());

       
        // impliment a connection to the postgres database
        try {
        Connection connection = DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/TransportApp",
        "postgres",
        "secret"
        );
        java.sql.Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT * FROM Inventar");
        while (resultSet.next()) {
        System.out.println(resultSet.getString("name"));
         }
        } catch (SQLException e) {
            logger.error("SQL DB ERROR", e);
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

        // count the inventory items and save them to a json file in the src folder
        /*try {
            FileWriter myWriter = new FileWriter(
                    "C:\\Users\\PC\\Documents\\Java Projects\\demo\\TransportApp\\AnzahlInventaritems.json");
            myWriter.write("Anzahl der Inventaritems: " + inventory.countAdequateItems());
            myWriter.close();
            logger.info("Successfully wrote to the file.");
        }
        // add logger
        catch (IOException e) {
            logger.error("Failed to write JSON file.");
        }

        try {
            JsonNode jsonTree = new ObjectMapper().readTree(
                    new File("C:\\Users\\PC\\Documents\\Java Projects\\demo\\TransportApp\\AnzahlInventaritems.json"));
            Builder csvSchemaBuilder = CsvSchema.builder();
            JsonNode firstObject = jsonTree

        // count the inventory items and save them to a json file in the src folder change the myWriter.write() to an array

        /*try {
            FileWriter myWriter = new FileWriter(
                    "C:\\Users\\PC\\Documents\\Java Projects\\demo\\TransportApp\\AnzahlInventaritems.json");
            myWriter.write("Anzahl der Inventaritems: " + inventory.countAdequateItems());
            myWriter.close();
            logger.info("Successfully wrote to the file.");
        }
        // add logger
        catch (IOException e) {
            logger.error("Failed to write JSON file.");
        }
        
        try {
            JsonNode jsonTree = new ObjectMapper().readTree(
                    new File("C:\\Users\\PC\\Documents\\Java Projects\\demo\\TransportApp\\AnzahlInventaritems.json"));
            Builder csvSchemaBuilder = CsvSchema.builder();
            JsonNode firstObject = jsonTree.elements().next();
            firstObject.fieldNames().forEachRemaining(fieldName -> {
                csvSchemaBuilder.addColumn(fieldName);
            });
            CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();
            CsvMapper csvMapper = new CsvMapper();
            try {
                csvMapper.writerFor(JsonNode.class)
                        .with(csvSchema)
                        .writeValue(
                                new File(
                                        "C:\\Users\\PC\\Documents\\Java Projects\\demo\\TransportApp\\AnzahlInventaritems.csv"),
                                jsonTree);
            }
            //add logger
            catch (IOException e) {
                logger.error("Failed to write CSV file.");
            }
        
        } catch (IOException e) {
            logger.error("Failed to read JSON file.");
        }
        } */
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
