


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Platno extends JPanel implements MouseListener, MouseMotionListener, KeyListener {
	private int sirina;
	private int visina;
	private Graf graf;
	private Color barvaPovezave;
	private Color barvaTocke;
	private Tocka aktivnaTocka;
	private Color barvaAktivne;
	private LinkedList<Tocka> oznacene;
	private Color barvaOznacene;
	private int prejsnjiX, prejsnjiY;
	private double aktX, aktY;
	private boolean narisi;


	
	public Platno(int s, int v) {
		sirina = s;
		visina = v;
		graf = null;
		aktivnaTocka = null;
		barvaPovezave = Color.RED;
		barvaTocke = Color.BLUE;
		barvaAktivne = Color.YELLOW;
		barvaOznacene = Color.BLACK;
		oznacene = new LinkedList<Tocka>();
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		setFocusable(true);

	}
	
	public void setTocke(Color b) {
		barvaTocke = b;
		setFocusable(true);
	}
	public Color getTocke () {
		return barvaTocke;
	}
	
	public void setPovezave(Color b) {
		barvaPovezave = b;
		setFocusable(true);
	}
	public Color getPovezave () {
		return barvaPovezave;
	}
	
	public void setAktivna(Color b) {
		barvaAktivne = b;
		setFocusable(true);
	}
	public Color getAktivna () {
		return barvaAktivne;
	}
	
	public void setOznacene(Color b) {
		barvaOznacene = b;
		setFocusable(true);
	}
	public Color getOznacene () {
		return barvaOznacene;
	}
	
	public Graf getGraf() {
		return graf;
	}
	public void setGraf(Graf g) {
		graf  = g;
		setFocusable(true);
	}
	
	public void narisi(Graf g) {
		graf = g;
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(sirina, visina);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		povezave(g);
		tocke(g);
		if (aktivnaTocka != null) aktivna(g);
		oznaceneRisi(g);
	}
	
	public void povezave(Graphics g) {
		g.setColor(barvaPovezave);
		for(Map.Entry<String, Tocka> ime : graf.slovar.entrySet()) {
			Tocka t = ime.getValue();
			for (Tocka r : t.sosedi) {
				g.drawLine((int) Math.round(t.x) , (int) Math.round(t.y), 
						(int) Math.round(r.x), (int) Math.round(r.y));
			}
		}
		this.repaint();
	}
	
	public void tocke(Graphics g) {
		g.setColor(barvaTocke);
		for(Map.Entry<String, Tocka> tocka : graf.slovar.entrySet()) {
			Tocka q = tocka.getValue();
			if ((q != aktivnaTocka) && (!oznacene.contains(q))) {
				int r = 10;
				g.fillOval((int) Math.round(q.x - r/2), (int) Math.round(q.y - r/2), r, r);
			}
		}
		this.repaint();
	}
	
	public void aktivna(Graphics g) {
		g.setColor(barvaAktivne);
		int r = 10;
		g.fillOval((int) Math.round(aktivnaTocka.x - r/2), (int) Math.round(aktivnaTocka.y - r/2), r, r);
		this.repaint();
	}
	
	public void oznaceneRisi(Graphics g) {
		g.setColor(barvaOznacene);
		for (Tocka t : oznacene) {
			int r = 10;
			g.fillOval((int) Math.round(t.x - r/2), (int) Math.round(t.y - r/2), r, r);
		}
		this.repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char crka = e.getKeyChar();

		if (crka == 'a') {
			for(Map.Entry<String, Tocka> tocka : graf.slovar.entrySet()) {
				Tocka t = tocka.getValue();
				if (!oznacene.contains(t)) oznacene.addLast(t);
			}
		}
		else if (crka == 's') {
			oznacene.clear();
		}
		else if (crka == 'q') {
			for (Tocka t : oznacene) {
				for (Tocka q : oznacene) {
					if (!t.sosedi.contains(q)) graf.dodajPovezavo(t, q);
				}
			}
		}
		else if (crka == 'w') {
			for (Tocka t : oznacene) {
				for (Tocka q : oznacene) {
					graf.odstraniPovezavo(t, q);
				}
			}
		}
		else if (crka == 'e') {
			for (Tocka t : oznacene) {
				graf.odstraniTocko(t);	
			}
			oznacene.clear();
		}
	}

	

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		narisi = true;
		for(Map.Entry<String, Tocka> ime : graf.slovar.entrySet()) {
			Tocka t = ime.getValue();
			if (((x-t.x)*(x-t.x) + (y-t.y)*(y-t.y) ) < 25) {
				aktivnaTocka = t;
				aktX = t.x;
				aktY = t.y;
			}
		}
		prejsnjiX = x;
		prejsnjiY = y;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if (aktivnaTocka == null) {
			if (narisi) {
				Tocka t = graf.dodajTocko(x, y);
				for (Tocka r : oznacene) {
					graf.dodajPovezavo(t, r);
				}
			}
		}
		else {
			if ((aktivnaTocka.x == aktX) && (aktivnaTocka.y == aktY)) {
				if (oznacene.contains(aktivnaTocka)) {
					oznacene.remove(aktivnaTocka);
				}
				else {
					oznacene.addLast(aktivnaTocka);
				}
			}
			aktivnaTocka = null;
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		narisi = false;
		if (aktivnaTocka != null) {
			aktivnaTocka.x = x;
			aktivnaTocka.y = y;
			
		}
		else {
			for (Tocka t : oznacene) {
				t.x += (x - prejsnjiX);
				t.y += (y - prejsnjiY);
			}
		}
		prejsnjiX = x;
		prejsnjiY = y;
		
	}
	
}
