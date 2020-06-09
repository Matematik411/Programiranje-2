public class Ladja {
	
	int nosilnost;
	Queue tovor;
	int odstranitve;

	public static void main(String[] args) {
		Ladja Titanik = new Ladja(100);
		Titanik.natovori(10);
		Titanik.natovori(54);
		Titanik.natovori(30);
		System.out.println(Titanik.tovor);
		Titanik.natovori(40);
		System.out.println(Titanik.tovor);
		System.out.println(Titanik.odstranjenih());

	}
	
	public Ladja(int n) {
		nosilnost = n;
		tovor = new Queue();
		odstranitve = 0;
	}

	public void natovori(int m) {
		tovor.put(m);
		while (tovor.skupna() > nosilnost) {
			tovor.take();
			odstranitve += 1;
		}
	}
	
	public int odstranjenih() {
		return odstranitve;
	}
}
