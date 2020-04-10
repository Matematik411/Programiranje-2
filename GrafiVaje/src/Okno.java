
import java.awt.Color;

import javax.swing.*;

@SuppressWarnings("serial")
public class Okno extends JFrame {
	private Platno platno;
	
	public Okno(int s, int v, Color b, Color c, Color d, Color e) {
		this.setTitle("Moja slika");
		platno = new Platno (s, v, b, c, d, e);
		platno.getPreferredSize();
		this.add(platno);
	}
	
	public void dodaj(Graf g) {
		platno.narisi(g);
	}
}
