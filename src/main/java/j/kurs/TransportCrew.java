package j.kurs;

public class TransportCrew {
    // TRransport crew can transport pallets and containers they have the access id of 1 they can only access the warehouse
    // where the pallets and containers are stored
    final private int accessId;
    final private Warehouse warehouse;

    public TransportCrew(int accessId, Warehouse warehouse) {
        this.accessId = accessId;
        this.warehouse = warehouse;
    }

    public void transport(Pallet pallet) {
        if (pallet != null) {
            warehouse.removePallet(pallet);
        }
    }

    public void transport(Container container) {
        if (container != null) {
            warehouse.removeContainer(container);
        }
    }

    public void transport(Inventory inventory) {
        if (inventory != null) {
            warehouse.removeInventory(inventory);
        }
    }

    public void transport(Transportierbar transportierbar) {
        if (transportierbar != null) {
            warehouse.removeTransportierbar(transportierbar);
        }
    }
}
