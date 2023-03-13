package ba.unsa.etf.rpr;

public class Radnik {
    private String imePrezime;
    private String jmbg;
    private double[] plate = new double[1000];

    public Radnik(String imePrezime, String jmbg) {
        this.imePrezime = imePrezime;
        this.jmbg = jmbg;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public void dodajPlatu(double plata) {
        for (int i = 0; i < plate.length; i++) {
            if (plate[i] == 0) {
                plate[i] = plata;
                return;
            }
        }
        throw new IllegalArgumentException("Ne možete registrovati više od 1000 plata za radnika " + imePrezime);
    }

    public double prosjecnaPlata() {
        double suma = 0;
        int brojac = 0;
        for (double plata : plate) {
            if (plata != 0) {
                suma += plata;
                brojac++;
            }
        }
        return brojac == 0 ? 0 : suma / brojac;
    }
}


