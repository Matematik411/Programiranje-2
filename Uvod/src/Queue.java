import java.util.ArrayList;

public class Queue {
	private ArrayList<Integer> holder;
	
	public Queue () {
		holder = new ArrayList<Integer> ();
	}
	public void put (int val) {
		holder.add(0, val);
	}
	
	public int take () { 
		int size = holder.size();
		return holder.remove(size-1);
	}
	
	public int size () {
		return holder.size ();
	}
	
	public boolean contains (int val) {
		return holder.contains (val);
	}
	
	public void clear () {
		holder.clear();
	}
	
	public int skupna() {
		int m = 0;
		for (int x : holder) m += x;
		return m;
	}
	
	@Override
	public String toString() {
		String niz = "";
		for (int x : holder) niz += " " + x;
		return niz;
	}
}