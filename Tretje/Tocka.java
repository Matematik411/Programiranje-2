package tretje;



import java.util.HashSet;
import java.util.Set;



public class Tocka {
	protected String ime;
	protected Set<Tocka> sosedi;
	
	public Tocka (String s) {
		ime = s;
		sosedi = new HashSet<Tocka>();
	}
	
	public int stopnja(Tocka t) {
		return sosedi.size();
	}

	
	private String izpisMnozice() {
		String zapis = "{";
		for (Tocka t : sosedi) {
			zapis += t.ime;
			zapis += ", ";
		}
		zapis += "}";
		return zapis;
	}

	
	@Override
	public String toString() {
		return "Sosedi: " + izpisMnozice();
	}


}



