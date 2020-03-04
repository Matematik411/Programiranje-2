import java.io.*;
import java.util.Locale;

public class Predor {

	public static void main(String[] args) throws IOException {
		int n = prekrski("podatki.txt", "krsitelji.txt");
		System.out.println(n);

	}

	public static int prekrski(String imeVhod, String imeIzhod) throws IOException {
		BufferedReader vhod = new BufferedReader(new FileReader(imeVhod)); // drug razred za branje datotek kot na predavanju
		PrintWriter izhod = new PrintWriter(new FileWriter(imeIzhod));
		
		int stevec = 0;
		while (vhod.ready()) {
			String vrstica = vhod.readLine().trim();
			if (vrstica.equals("")) continue;
			
			String[] besede = vrstica.split(" +");
			int s = Integer.parseInt(besede[0]);
			int t = Integer.parseInt(besede[1]);
			String r = besede[2];
			double v = 622.0 / (t - s) * 3.6;
			if (v > 80) {
				izhod.println(r + " " + String.format(Locale.US, "%.2f", v)) ;
				stevec += 1;
			};
			
			
		};
		vhod.close();
		izhod.close();
		return stevec;
	}
	
}
