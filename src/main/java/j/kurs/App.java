package j.kurs;

public class App {
    public static void main(String[] args) {
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

