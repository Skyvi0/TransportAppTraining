package j.kurs;

public class App {
    public static void main(String[] args) {
        Transportierbar glasTisch = new Tisch(30, true);
        System.out.println("Das Gewicht des Tisches ist: " + glasTisch.gewicht() + "kg" + " und zerbrechlich: "
                + glasTisch.zerbrechlich());
    }
}
