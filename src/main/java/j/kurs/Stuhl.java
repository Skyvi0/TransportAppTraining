package j.kurs;


    public class Stuhl implements Transportierbar {
        private final float gewicht;
        private final boolean zerbrechlich;
    
        public Stuhl(float gewicht, boolean zerbrechlich) {
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

    }
