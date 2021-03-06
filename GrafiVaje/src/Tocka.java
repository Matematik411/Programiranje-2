


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



public class Tocka implements Serializable {
	static final long serialVersionUID = 1L;
	
	protected String ime;
	protected Set<Tocka> sosedi;
	protected double x;
	protected double y;
	
	public Tocka (String s) {
		ime = s;
		sosedi = new HashSet<Tocka>();
		x = 0;
		y = 0;
	}
	
	public int stopnja(Tocka t) {
		return sosedi.size();
	}

	
	private String izpisMnozice() {
		String zapis = "Sosedi: {";
		for (Tocka t : sosedi) {
			zapis += t.ime;
			zapis += ", ";
		}
		zapis += "}";
		zapis += ", lokacija: (" + (String.valueOf(x)) + ", " + 
				(String.valueOf(y)) + ')';
		
		return zapis;
	}

	
	@Override
	public String toString() {
		return izpisMnozice();
	}


}



