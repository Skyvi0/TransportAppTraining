package j.kurs;

public class Pallet {

    // packs boxes into a pallet if the amount reaches 10
    public void pack(Inventory inventory) {
        int amount = 0;
        for (Transportierbar item : ((Transportierbar) inventory).getItems()) {
            if (item instanceof Box) {
                amount++;
            }
        }
        if (amount == 10) {
            System.out.println("Pallet is full");
        }
    }

}
