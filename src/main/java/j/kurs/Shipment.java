package j.kurs;

public class Shipment {
    // pack inventory into a shipment
    public void pack(Inventory inventory) {
        Container container = new Container();
        Pallet pallet = new Pallet();
        Box box = new Box();
        int amount = 0;
        for (Transportierbar item : ((Transportierbar) inventory).getItems()) {
            if (item instanceof Box) {
                amount++;
                if (amount == 10) {
                    container.pack(pallet);
                    pallet = new Pallet();
                    amount = 0;
                }
                box.pack(inventory);
            }
        }

    }

    public void add(Container container) {
    }

}
