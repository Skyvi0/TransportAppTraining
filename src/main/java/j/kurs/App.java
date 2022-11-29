package j.kurs;

import java.io.FileWriter;

public class App {
    public static void main(String[] args)  {
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

        // count the inventory items and save them to a text file in the src folder
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\PC\\Documents\\Java Projects\\demo\\TransportApp\\AnzahlInventaritems.txt");
            myWriter.write("Anzahl der Inventaritems: " + inventory.countAdequateItems());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (Exception e) {
            System.out.println("An error occurred.");
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

    // save the inventory to a file txt in the same directory as the program 
    public static void save(Inventory inventory) {
        try (FileWriter writer = new FileWriter("inventory.txt")) {
            for (Transportierbar item : inventory.getItems()) {
                if (item != null) {
                    writer.write(item.toString() + "test" + item.gewicht() + "kg" + "test2" + item.zerbrechlich() + "test3"
                            + item.countAdequateItems());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
