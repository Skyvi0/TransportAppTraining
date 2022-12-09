package j.kurs;

public class Tisch implements Transportierbar {
    private final float gewicht;
    private final boolean zerbrechlich;

    public Tisch(float gewicht, boolean zerbrechlich) {
        this.gewicht = gewicht;
        this.zerbrechlich = zerbrechlich;
    }

    @Override
    public float gewicht() {
        return gewicht;
    }

    @Override
    public boolean zerbrechlich() {
        return zerbrechlich;
    }

    // include countAdequateItems() in the interface
    @Override
    public int countAdequateItems() {
        return 0;
    }

    @Override
    public void wrap(Transportierbar item) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Transportierbar[] getItems() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BubbleWrap wrap() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SecureBox secureBox() {
        // TODO Auto-generated method stub
        return null;
    }

}