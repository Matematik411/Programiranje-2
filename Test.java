package tretje;

import java.awt.Color;

public class Test {

	public static void main(String[] args) {
		
		Graf g = new Graf();
		Tocka a = g.dodajTocko("prva");
		Tocka b = g.dodajTocko();
		Tocka c =g.dodajTocko("druga");
		g.dodajPovezavo(b, c);
		g.dodajPovezavo(c, a);
		g.razporedi(300, 300, 100);
		g.izpis();
		
		Graf h = g.prazen(8);
		h.razporedi(300, 300, 100);
		h.izpis();
		
		Graf j = g.cikel(10);
		j.razporedi(250, 250, 100);
		j.izpis();
			
		Graf k = g.poln(25);
		k.razporedi(350, 350, 300);
		k.izpis();
			
		Graf l = g.polnDvodelen(10, 4);
		l.razporedi(350, 350, 300);
		l.izpis();
		
		
		Okno okno1 = new Okno (750, 750, Color.BLUE);
		okno1.pack();
		okno1.setVisible(true);
		okno1.dodaj(l);
		// okno1.dodaj(j);
		
	}

}
