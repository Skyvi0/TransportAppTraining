package j.kurs;

public class BubbleWrap {

    // make an if else statement checking if the item is zerbrechlich and if it is wrap it in bubble wrap and put it in a secure box
    public void wrap(Transportierbar item) {
        if (item.zerbrechlich()) {
            item.wrap();

        }

    }
}
