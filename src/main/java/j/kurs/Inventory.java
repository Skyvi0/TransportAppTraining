package j.kurs;

public class Inventory {
    // array of Transportierbar objects (Tisch, Stuhl, etc.)
    private final Transportierbar[] inventar;
    // number of items in the inventory
    private int count;
    // maximum number of items in the inventory 
    private final int max;
    // constructor with max number of items in the inventory as parameter 
    public Inventory(int max) {
        this.max = max;
        inventar= new Transportierbar[max];
        count = 0;
    }
    // add an item to the inventory 
    public void add(Transportierbar item) {
        if (count < max) {
            inventar[count] = item;
            count++;
        }
    }
    // remove an item from the inventory 
    public void remove(Transportierbar item) {
        for (int i = 0; i < count; i++) {
            if (inventar[i] == item) {
                inventar[i] = inventar[count - 1];
                inventar[count - 1] = null;
                count--;
                break;
            }
        }
    }
    // get the total weight of the inventory 
    public float totalWeight() {
        float total = 0;
        for (int i = 0; i < count; i++) {
            total += inventar[i].gewicht();
        }
        return total;
    }

    public Transportierbar[] getItems() {
        return inventar;
    }

    //count the adequate items in the inventory
    public int countAdequateItems() {
        int countAdequateItems = 0;
        for (int i = 0; i < count; i++) {
            if (!inventar[i].zerbrechlich()) {
                countAdequateItems++;
            }
        }
        return countAdequateItems;
    }
}