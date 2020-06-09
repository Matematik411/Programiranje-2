import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Izpit {

	public static void main(String[] args) throws IOException {
		izpisi("izpit.txt");

	}

	public static void izpisi(String imeVhoda) throws IOException {
		BufferedReader vhod = new BufferedReader(new FileReader(imeVhoda));
		
		int[] ocene = new int[10];
		while (vhod.ready()) {
			String vrstica = vhod.readLine().trim();
			if (vrstica.equals("")) continue;
			
			String[] besede = vrstica.split(" +");
			int s = Integer.parseInt(besede[2]);
			int ocena = Math.min((s / 10) + 1, 10);
			ocene[ocena-1] += 1;
			
		}
		vhod.close();
		
		for (int k = 0; k < 10; ++k) {

			if (k == 9) {
				System.out.print((k + 1) + ": ");
				for (int l = 0; l < ocene[k]; ++l) System.out.print("*");
				System.out.println("");
			}
			else {
				System.out.print(" " + (k + 1) + ": ");
				for (int l = 0; l < ocene[k]; ++l) System.out.print("*");
				System.out.println("");
			}

			
		}

	}
}
