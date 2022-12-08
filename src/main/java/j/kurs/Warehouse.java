package j.kurs;

public class Warehouse {
    // can only be accessed if the security id is 1 - 5 the id is used to check if they have access to that area
    // the warehouse has a max capacity of 100 pallets and 100 containers
    final private int securityId;
    // the pallets and containers are stored in the warehouse
    final private Pallet[] pallets;
    final private Container[] containers;

    public Warehouse(int securityId, Pallet[] pallets, Container[] containers) {
        this.securityId = securityId;
        this.pallets = pallets;
        this.containers = containers;
    }

    private void securityCheck(int securityId) {
        if (securityId < 1 || securityId > 5) {
            throw new IllegalArgumentException("Security ID must be between 1 and 5");
        }
    }

    public void addPallet(Pallet pallet) {
        //add security check
        securityCheck(securityId);
        if (pallet != null && securityId > 1) {
            for (int i = 0; i < pallets.length; i++) {
                if (pallets[i] == null) {
                    pallets[i] = pallet;
                    break;
                }
            }
        }
    }

    public void addContainer(Container container) {
        if (container != null && securityId > 1) {
            for (int i = 0; i < containers.length; i++) {
                if (containers[i] == null) {
                    containers[i] = container;
                    break;
                }
            }
        }
    }

    public void removePallet(Pallet pallet) {
        if (pallet != null && securityId > 2) {
            for (int i = 0; i < pallets.length; i++) {
                if (pallets[i] == pallet) {
                    pallets[i] = null;
                    break;
                }
            }
        }
    }

    public void removeContainer(Container container) {
        if (container != null && securityId > 2) {
            for (int i = 0; i < containers.length; i++) {
                if (containers[i] == container) {
                    containers[i] = null;
                    break;
                }
            }
        }
    }

    public void removeInventory(Inventory inventory) {
        if (inventory != null ) {
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

    public void add(Inventory inventory) {
    }

}
