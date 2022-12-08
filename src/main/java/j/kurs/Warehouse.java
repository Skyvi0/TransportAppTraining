package j.kurs;

public class Warehouse {
    // the pallets and containers are stored in the warehouse
    final private Pallet[] pallets;
    final private Container[] containers;

    public Warehouse(Pallet[] pallets, Container[] containers) {
        this.pallets = pallets;
        this.containers = containers;
    }

    public void addPallet(Pallet pallet) {
        if (pallet != null) {
            for (int i = 0; i < pallets.length; i++) {
                if (pallets[i] == null) {
                    pallets[i] = pallet;
                    break;
                }
            }
        }
    }

    public void addContainer(Container container) {
        if (container != null) {
            for (int i = 0; i < containers.length; i++) {
                if (containers[i] == null) {
                    containers[i] = container;
                    break;
                }
            }
        }
    }

    public void removePallet(Pallet pallet) {
        if (pallet != null) {
            for (int i = 0; i < pallets.length; i++) {
                if (pallets[i] == pallet) {
                    pallets[i] = null;
                    break;
                }
            }
        }
    }

    public void removeContainer(Container container) {
        if (container != null) {
            for (int i = 0; i < containers.length; i++) {
                if (containers[i] == container) {
                    containers[i] = null;
                    break;
                }
            }
        }
    }

    public void removeInventory(Inventory inventory) {
        if (inventory != null) {
            for (Transportierbar item : inventory.getItems()) {
                removeTransportierbar(item);
            }
        }
    }

    public void removeTransportierbar(Transportierbar transportierbar) {
        if (transportierbar != null) {
            if (transportierbar instanceof Pallet) {
                removePallet((Pallet) transportierbar);
            } else if (transportierbar instanceof Container) {
                removeContainer((Container) transportierbar);
            }
        }
    }
}
