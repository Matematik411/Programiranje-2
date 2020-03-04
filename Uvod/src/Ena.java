
public class Ena {

	public static void main(String[] args) {
		String[] zap = zaporedje(20);
		for (int i = 0; i < zap.length; i++) System.out.println(zap[i]);
		
	}

	
	public static String[] zaporedje(int n) {
		String[] zap = new String[n];
		zap[0] = "1";
		for (int i = 1; i < n; ++i) {
			String p = zap[i - 1];  // ne naredi kopije, samo še en kazalec na to spremenljivko
			String t = "";
			int j = 0;              // indeks, ki bo šel čez niz p

			while (j < p.length()) {  // zanka po blokih
				int k = j;
				while (j < p.length() && p.charAt(k) == p.charAt(j)) j++;
				t += "" + (j - k) + p.charAt(k); // lepo spremeni vse v nize, zato tam na začetku ""
			};
			
			zap[i] = t; 
		};
		
		return zap;	
	}
}
