public class Bitki {

	public static void main(String[] args) {
		for (int k : pretvori("00110010011101101010101011110000")) System.out.println(k);

	}

	public static int[] pretvori(String zacetni) {
		int n = zacetni.length();
		int[] tabela = new int[n/8];
		for (int i = 0; i < n/8; ++i) {
			String trenutni = zacetni.substring(8 * i, 8 * (i + 1));
			int stevilo = 0;
			for (int j = 0; j < 8; ++j) {
				if (Character.getNumericValue(trenutni.charAt(7 - j)) == 1) stevilo += Math.pow(2, j);
			}
			tabela[i] = stevilo;
		}
		return tabela;
	}
}
