package tretje;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;


public class Graf {
	protected int stevec;
	protected Map<String, Tocka> slovar;
	
	public Graf () {
		stevec = 0;
		slovar = new HashMap<String, Tocka>();
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

	public Graf prazen(int n) {
		Graf g = new Graf();
		g.dodajTocke(n);
		return g;
	}
	
	public Graf cikel(int n) {
		Graf g = new Graf();
		Tocka a = g.dodajTocko();
		Tocka prva = a;
		for (int i = 1; i < n ; i++) {
			Tocka b = g.dodajTocko();
			dodajPovezavo(a, b);
			a = b;
			if (i == n - 1) {
				dodajPovezavo(prva, b);
			}
		}
		return g;
	}
	
	public Graf poln(int n) {
		Graf g = prazen(n);
		for(Map.Entry<String, Tocka> prva : g.slovar.entrySet()) {
			for(Map.Entry<String, Tocka> druga : g.slovar.entrySet()) {
				if (prva.getKey() != druga.getKey()) {
					prva.getValue().sosedi.add(druga.getValue());
				}
			}
		}
		return g;
	}
	
	
	
	
	public Graf polnDvodelen(int n, int m) {
		Graf g = new Graf();
		Tocka[] prve = g.dodajTocke(n);
		g.dodajTocke(m);
		for(Map.Entry<String, Tocka> prva : g.slovar.entrySet()) {
			for(Map.Entry<String, Tocka> druga : g.slovar.entrySet()) {
				Tocka t = prva.getValue();
				Tocka r = druga.getValue();
				boolean dodaj = false;
				for (Tocka q : prve) {
					if (q == t) {
						dodaj = !dodaj;
					}
					if (q == r) {
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
	
	
	
	
	
	
	
	

	
	
	public void izpis() {
		System.out.print("Graf je iz tock : ");
		for (Map.Entry<String, Tocka> t : slovar.entrySet()) {
			System.out.println(t);
		}
	}
	
	
	
}
