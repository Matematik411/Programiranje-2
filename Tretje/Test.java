package tretje;

public class Test {

	public static void main(String[] args) {
		
		Graf g = new Graf();
		Tocka a = g.dodajTocko("prva");
		Tocka b = g.dodajTocko();
		Tocka c =g.dodajTocko("druga");
		g.dodajPovezavo(b, c);
		g.dodajPovezavo(c, a);
		g.izpis();
		
		Graf h = g.prazen(10);
		h.izpis();
		
		Graf j = g.cikel(10);
		j.izpis();
			
		Graf k = g.poln(5);
		k.izpis();
			
		Graf l = g.polnDvodelen(4, 2);
		l.izpis();
		
	}

}
