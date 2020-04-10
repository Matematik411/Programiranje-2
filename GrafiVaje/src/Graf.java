

import java.util.Map;
import java.util.HashMap;


public class Graf {
	protected int stevec;
	protected Map<String, Tocka> slovar;
	protected int polmer;

	
	public Graf (int r) {
		stevec = 0;
		slovar = new HashMap<String, Tocka>();
		polmer = r;
	}

	public Tocka tocka(String s) {
		if (slovar.containsKey(s)) {
			return slovar.get(s);
		}
		else {
			return null;
		}
	}
	
	public boolean povezava(Tocka t, Tocka r) {
		return t.sosedi.contains(r);
	}
	
	public Tocka dodajTocko(String s) {
		if (tocka(s) == null) {
			Tocka t = new Tocka(s);
			slovar.put(s, t);
			return t;
		}
		else {
			return slovar.get(s);
		}
	}
	
	public Tocka dodajTocko() {
		stevec++;
		return dodajTocko(String.valueOf(stevec));
	}
	
	public Tocka dodajTocko(int x, int y) {
		stevec++;
		Tocka t =  dodajTocko(String.valueOf(stevec));
		t.x = x;
		t.y = y;
		return t;
	}
	
	
	
	public void dodajPovezavo(Tocka t, Tocka r) {
		if (t != r) {
			t.sosedi.add(r);
			r.sosedi.add(t);
		}
	}
	
	public void odstraniPovezavo(Tocka t, Tocka r) {
		t.sosedi.remove(r);
		r.sosedi.remove(t);
	}
	
	public void odstraniTocko(Tocka t) {
		slovar.remove(t.ime);
		for (Tocka r : t.sosedi) {
			r.sosedi.remove(t);
		}
	}
	
	private Tocka[] dodajTocke(int n) {
		Tocka[] tab = new Tocka[n];
		for (int i = 0; i < n; i++) {
			tab[i] = dodajTocko();
		}
		return tab;
	}

	public Graf prazen(int n, int r) {
		Graf g = new Graf(r);
		g.dodajTocke(n);
		return g;
	}
	
	public Graf cikel(int n, int r) {
		Graf g = new Graf(r);
		Tocka a = g.dodajTocko();
		Tocka prva = a;
		for (int i = 1; i < n ; i++) {
			Tocka q = g.dodajTocko();
			dodajPovezavo(a, q);
			a = q;
			if (i == n - 1) {
				dodajPovezavo(prva, q);
			}
		}
		return g;
	}
	
	public Graf poln(int n, int r) {
		Graf g = prazen(n, r);
		for(Map.Entry<String, Tocka> prva : g.slovar.entrySet()) {
			for(Map.Entry<String, Tocka> druga : g.slovar.entrySet()) {
				if (prva.getKey() != druga.getKey()) {
					prva.getValue().sosedi.add(druga.getValue());
				}
			}
		}
		return g;
	}
	
	
	
	
	public Graf polnDvodelen(int n, int m, int r) {
		Graf g = new Graf(r);
		Tocka[] prve = g.dodajTocke(n);
		g.dodajTocke(m);
		for(Map.Entry<String, Tocka> prva : g.slovar.entrySet()) {
			for(Map.Entry<String, Tocka> druga : g.slovar.entrySet()) {
				Tocka t = prva.getValue();
				Tocka s = druga.getValue();
				boolean dodaj = false;
				for (Tocka q : prve) {
					if (q == t) {
						dodaj = !dodaj;
					}
					if (q == s) {
						dodaj = !dodaj;
					}
				}
				if (dodaj) {
					prva.getValue().sosedi.add(druga.getValue());
				}
			}
		}
		return g;
	}
	
	public void razporedi(double x, double y) {
		int velikost = slovar.size();
		double alpha = 2 * Math.PI / velikost;
		double kot = 0;
		for(Map.Entry<String, Tocka> ime : slovar.entrySet()) {
			Tocka t = ime.getValue();
			t.x = x + Math.cos(kot) * polmer;
			t.y = y + Math.sin(kot) * polmer;
			kot += alpha;
		}
	}
	
	
	
	
	

	
	
	public void izpis() {
		System.out.print("Graf je iz tock : ");
		for (Map.Entry<String, Tocka> t : slovar.entrySet()) {
			System.out.println(t);
		}
	}
	
	
	
}
