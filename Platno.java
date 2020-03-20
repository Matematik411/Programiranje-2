package tretje;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Map;
import javax.swing.JPanel;

import java.awt.Color;

@SuppressWarnings("serial")
public class Platno extends JPanel{
	private int sirina;
	private int visina;
	private Graf graf;
	private Color barva;

	
	public Platno(int s, int v, Color c) {
		sirina = s;
		visina = v;
		graf = null;
		barva = c;
	}
	
	public void narisi(Graf g) {
		graf = g;
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(sirina, visina);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(barva);
		for(Map.Entry<String, Tocka> ime : graf.slovar.entrySet()) {
			Tocka t = ime.getValue();
			for (Tocka r : t.sosedi) {
				g.drawLine((int) Math.round(t.x) , (int) Math.round(t.y), 
						(int) Math.round(r.x), (int) Math.round(r.y));
			}
		for(Map.Entry<String, Tocka> tocka : graf.slovar.entrySet()) {
			Tocka q = tocka.getValue();
			int r = 10;
			g.fillOval((int) Math.round(q.x - r/2), (int) Math.round(q.y - r/2), r, r);
			}
		}
	}
	
	
}
