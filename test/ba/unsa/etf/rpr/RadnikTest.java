package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadnikTest {



    @Test
    public void radnikTest0() {

        Radnik radnik = new Radnik("Meho Mehić", "12345");
        assertEquals("Meho Mehić", radnik.getImePrezime());

    }

    @Test
    public void radnikTest01() {
        Radnik radnik = new Radnik("Meho Mehić", "12345");
        assertEquals("12345", radnik.getJmbg());

    }



    @Test
    public void radnikTest1() {
        Radnik radnik = new Radnik("Meho Mehić", "12345");
        assertEquals("Meho Mehić", radnik.getImePrezime());
        assertEquals("12345", radnik.getJmbg());
        // Drugi test?
        radnik.setImePrezime("Pero Perić");
        radnik.setJmbg("54321");
        assertEquals("Pero Perić", radnik.getImePrezime());
        assertEquals("54321", radnik.getJmbg());
    }

    @Test
    public void radnikTest2() {
        // Drugi test?
        Radnik radnik = new Radnik("Meho Mehić", "12345");
        radnik.setImePrezime("Pero Perić");
        radnik.setJmbg("54321");
        assertEquals("Pero Perić", radnik.getImePrezime());
        assertEquals("54321", radnik.getJmbg());
    }


    @Test
    public void radnikDodajPlatu02() {
        Radnik radnik = new Radnik("Sara Sarač", "12345");
        radnik.dodajPlatu(1000);
        assertEquals(1000, radnik.prosjecnaPlata());
    }
    @Test
    public void radnikDodajPlatu0() {
        Radnik radnik = new Radnik("Sara Sarač", "12345");
        assertEquals(0, radnik.prosjecnaPlata());
    }

    @Test
    public void radnikDodajPlatu1() {
        Radnik radnik = new Radnik("Sara Sarač", "12345");
        radnik.dodajPlatu(1000);
        assertEquals(1000, radnik.prosjecnaPlata());
        radnik.dodajPlatu(500);
        assertEquals(750, radnik.prosjecnaPlata());
        radnik.dodajPlatu(500);
        assertEquals(667, Math.round(radnik.prosjecnaPlata()));
    }

    @Test
    public void radnikDodajPlatu2() {
        Radnik radnik = new Radnik("Sara Sarač", "12345");
        radnik.dodajPlatu(1000);

        radnik.dodajPlatu(500);
        assertEquals(750, radnik.prosjecnaPlata());

    }

    @Test
    public void radnikDodajPlatu3() {
        Radnik radnik = new Radnik("Sara Sarač", "12345");
        radnik.dodajPlatu(1000);

        radnik.dodajPlatu(500);

        radnik.dodajPlatu(500);
        assertEquals(667, Math.round(radnik.prosjecnaPlata()));
    }





    @Test
    public void radnikDodajPlatuIzuzetak() {
        Radnik radnik = new Radnik("Maja Majić", "12345");
        for (int i=0; i<1000; i++)
            radnik.dodajPlatu(1000);
        assertEquals(1000, radnik.prosjecnaPlata());
        assertThrows(IllegalArgumentException.class,
                () -> radnik.dodajPlatu(0),
                "Ne možete registrovati više od 1000 plata za radnika Maja Majić");
        assertEquals(1000, radnik.prosjecnaPlata());
    }



}


