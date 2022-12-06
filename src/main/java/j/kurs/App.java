package j.kurs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder;

public class App {

    public static void main(String[] args) {
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
        System.out.println("Das Gewicht des Tisches ist: " + glasTisch.gewicht() + "kg" + " und zerbrechlich: "
                + glasTisch.zerbrechlich());
        System.out.println("Total weight: " + inventory.totalWeight());

        // count the inventory items and save them to a json file in the src folder change the myWriter.write() to an array
    
        try {
            FileWriter myWriter = new FileWriter(
                    "C:\\Users\\PC\\Documents\\Java Projects\\demo\\TransportApp\\AnzahlInventaritems.json");
            myWriter.write("Anzahl der Inventaritems: " + inventory.countAdequateItems());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // read the json file in src folder and write the content to a csv file in the src folder use jackson to read the json
        // file and write the content to a csv file
        // catch hinzufügen
        
        try {
            JsonNode jsonTree = new ObjectMapper().readTree(
                    new File("C:\\Users\\PC\\Documents\\Java Projects\\demo\\TransportApp\\AnzahlInventaritems.json"));
                    Builder csvSchemaBuilder = CsvSchema.builder();
                    JsonNode firstObject = jsonTree.elements().next();
                    firstObject.fieldNames().forEachRemaining(fieldName -> {csvSchemaBuilder.addColumn(fieldName);} );
                    CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();
                CsvMapper csvMapper = new CsvMapper();
        try {
            csvMapper.writerFor(JsonNode.class)
                    .with(csvSchema)
                    .writeValue(
                            new File(
                                    "C:\\Users\\PC\\Documents\\Java Projects\\demo\\TransportApp\\AnzahlInventaritems.csv"), jsonTree);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
