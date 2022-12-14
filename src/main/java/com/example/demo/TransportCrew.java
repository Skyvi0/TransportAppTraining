package com.example.demo;

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
        if (pallet != null && accessId > 1) {
            warehouse.removePallet(pallet);
        }
    }

    public void transport(Container container) {
        if (container != null && accessId > 1) {
            warehouse.removeContainer(container);
        }
    }

    public void transport(Inventory inventory) {
        if (inventory != null && accessId > 1) {
            warehouse.removeInventory(inventory);
        }
    }

    public void transport(Transportierbar transportierbar) {
        if (transportierbar != null && accessId > 1) {
            warehouse.removeTransportierbar(transportierbar);
        }
    }

}
