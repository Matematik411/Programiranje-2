
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class Okno extends JFrame implements ActionListener, ChangeListener {
	private Platno platno;
	
	private JMenu osnovni;
	private JMenuBar mb;
	private JMenuItem i1, i2, i3, i4;
	private JButton tocke;
	private JLabel tockeLabel;
	private JButton aktivna;
	private JLabel aktivnaLabel;
	private JButton oznacene;
	private JLabel oznaceneLabel;
	private JButton povezave;
	private JLabel povezaveLabel;
	
	private JButton izhod;
	private JButton shrani;
	private JButton nalozi;
	
	//private final JFileChooser FC = new JFileChooser ();
	
	public Okno(int s, int v) {
		setTitle("Risanje grafov");
		
		// glavni okvir
		JPanel glavniOkvir = new JPanel();
		glavniOkvir.setLayout(new BoxLayout(glavniOkvir, BoxLayout.Y_AXIS));
		add(glavniOkvir);
		
		// platno za grafe
		platno = new Platno (s, v);
		platno.getPreferredSize();
		glavniOkvir.add(platno);
		
		// menu za nastavitve
		JPanel menu = new JPanel();
		
		mb = new JMenuBar();
		osnovni = new JMenu("Osnovni");
		i1 = new JMenuItem("Prazen graf");
		i1.addActionListener(this);
		i2 = new JMenuItem("Cikel");
		i2.addActionListener(this);
		i3 = new JMenuItem("Poln graf");
		i3.addActionListener(this);
		i4 = new JMenuItem("Poln dvodelen graf");
		i4.addActionListener(this);
		osnovni.add(i1);
		osnovni.add(i2);
		osnovni.add(i3);
		osnovni.add(i4);
		mb.add(osnovni);
		menu.add(mb);
		
		
		Color povezaveBarva = Color.RED;
		povezaveLabel = new JLabel("    ");
		povezaveLabel.setOpaque(true);
		povezaveLabel.setBackground(povezaveBarva);
		platno.setPovezave(povezaveBarva);
		povezave = new JButton("Barva povezav");
		povezave.addActionListener(this);
		menu.add(povezaveLabel);
		menu.add(povezave);
		
		Color tockeBarva = Color.BLUE;
		tockeLabel = new JLabel("    ");
		tockeLabel.setOpaque(true);
		tockeLabel.setBackground(tockeBarva);
		platno.setTocke(tockeBarva);
		tocke = new JButton("Barva toèk");
		tocke.addActionListener(this);
		menu.add(tockeLabel);
		menu.add(tocke);
		
		Color aktivnaBarva = Color.YELLOW;
		aktivnaLabel = new JLabel("    ");
		aktivnaLabel.setOpaque(true);
		aktivnaLabel.setBackground(aktivnaBarva);
		platno.setAktivna(aktivnaBarva);
		aktivna = new JButton("Barva aktivne");
		aktivna.addActionListener(this);
		menu.add(aktivnaLabel);
		menu.add(aktivna);
		
		Color oznaceneBarva = Color.BLACK;
		oznaceneLabel = new JLabel("    ");
		oznaceneLabel.setOpaque(true);
		oznaceneLabel.setBackground(oznaceneBarva);
		platno.setOznacene(oznaceneBarva);
		oznacene = new JButton("Barva oznacenih");
		oznacene.addActionListener(this);
		menu.add(oznaceneLabel);
		menu.add(oznacene);
		
		glavniOkvir.add(menu);
		
		// shrani, nalozi in izhod
		JPanel datoteke = new JPanel();
		datoteke.setLayout(new FlowLayout(FlowLayout.TRAILING));
		
		shrani = new JButton("Shrani");
		datoteke.add(shrani);
		shrani.addActionListener(this);
		
		nalozi = new JButton("Nalozi");
		datoteke.add(nalozi);
		nalozi.addActionListener(this);
		
		izhod = new JButton("Izhod");
		datoteke.add(izhod);
		izhod.addActionListener(this);
		
		glavniOkvir.add(datoteke);
	}
	
	public void dodaj(Graf g) {
		platno.narisi(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == povezave) {
			Color novaBarva = JColorChooser.showDialog(this, "Izberite barvo", platno.getPovezave());
			if (novaBarva != null) {
				platno.setPovezave(novaBarva);
				povezaveLabel.setBackground(novaBarva);
			}
		}
		else if (e.getSource() == tocke) {
			Color novaBarva = JColorChooser.showDialog(this, "Izberite barvo", platno.getTocke());
			if (novaBarva != null) {
				platno.setTocke(novaBarva);
				tockeLabel.setBackground(novaBarva);
			}
		}
		else if (e.getSource() == oznacene) {
			Color novaBarva = JColorChooser.showDialog(this, "Izberite barvo", platno.getOznacene());
			if (novaBarva != null) {
				platno.setOznacene(novaBarva);
				oznaceneLabel.setBackground(novaBarva);
			}
		}
		else if (e.getSource() == aktivna) {
			Color novaBarva = JColorChooser.showDialog(this, "Izberite barvo", platno.getAktivna());
			if (novaBarva != null) {
				platno.setAktivna(novaBarva);
				aktivnaLabel.setBackground(novaBarva);
			}
		}
		else if (e.getSource() == i1) {
			Graf g = new Graf(1);
			Graf h = g.prazen(10, 225);
			h.razporedi(300, 300);
			dodaj(h);
		}
		else if (e.getSource() == i2) {
			Graf g = new Graf(1);
			Graf h = g.cikel(10, 225);
			h.razporedi(300, 300);
			dodaj(h);
		}
		else if (e.getSource() == i3) {
			Graf g = new Graf(1);
			Graf h = g.poln(10, 225);
			h.razporedi(300, 300);
			dodaj(h);
		}
		else if (e.getSource() == i4) {
			Graf g = new Graf(1);
			Graf h = g.polnDvodelen(12, 6, 225);
			h.razporedi(300, 300);
			dodaj(h);
		}
		
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
