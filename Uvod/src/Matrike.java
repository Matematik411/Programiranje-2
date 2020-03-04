
public class Matrike {

	public static void main(String[] args) {
		double[][] a = {{1, 2}, {3, 4, 5}, {6, 7}, null, {}, {8, 9, 10}};
		double[][] b = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		
		izpis(a);
		System.out.println();
		izpis(b);
		System.out.println();
		System.out.println(jeMatrika(a));
		System.out.println();
		System.out.println(jeMatrika(b));
		System.out.println();
		izpis(transponiraj(a));
		System.out.println();
		izpis(transponiraj(b));
		
		
		
	}

	public static void izpis(double[][] tabela) {
		if (tabela == null) System.out.println("NULL");
		else {
			for (int i = 0; i < tabela.length; ++i) {
				double[] v = tabela[i];
				if (v == null) System.out.println("null");
				else {
					for (int j = 0; j < v.length; ++j) {
						System.out.print(v[j] + "\t");
					}
					System.out.println();
				}
			}
		}
	}
	
	public static boolean jeMatrika(double[][] tabela) {
		if (tabela == null) return false;
		
		for (int i = 0; i < tabela.length; ++i) {
			if (tabela[i] == null) return false;
			
			if (tabela[i].length != tabela[0].length) return false;
		};
		
		return true;
	}
	
	public static double[][] transponiraj(double[][] tabela) {
		if (!jeMatrika(tabela)) return null;
		
		int v = tabela.length;
		int d = tabela[0].length;
		double[][] mat = new double[d][v];
			
		for (int i = 0; i < d; ++i) {
			for (int j = 0; j < v; ++j) {
				mat[i][j] = tabela[j][i];
			};
		};
		return mat;
				
	}
	
	
}
