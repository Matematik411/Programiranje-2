
import java.awt.Color;

public class Test {

	public static void main(String[] args) {
		
		Graf g = new Graf(100);
		Tocka a = g.dodajTocko("prva");
		Tocka b = g.dodajTocko();
		Tocka c =g.dodajTocko("druga");
		g.dodajPovezavo(b, c);
		g.dodajPovezavo(c, a);
		g.razporedi(300, 300);
		g.izpis();
		
		Graf h = g.prazen(8, 100);
		h.razporedi(300, 300);
		h.izpis();
		
		Graf j = g.cikel(10, 100);
		j.razporedi(250, 250);
		j.izpis();
			
		Graf k = g.poln(25, 300);
		k.razporedi(350, 350);
		k.izpis();
			
		Graf l = g.polnDvodelen(10, 4, 250);
		l.razporedi(300, 300);
		l.izpis();
		
		
		Okno okno1 = new Okno (650, 650, Color.RED, Color.BLUE, Color.YELLOW, Color.BLACK);
		okno1.pack();
		okno1.setVisible(true);
		okno1.dodaj(l);
		// okno1.dodaj(k);
		
	}

}
