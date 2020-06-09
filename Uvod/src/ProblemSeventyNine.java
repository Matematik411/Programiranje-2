import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ProblemSeventyNine {

	public static void main(String[] args) throws IOException{

		System.out.println(resitev());

	}

	public static ArrayList<ArrayList<Integer>> resitev() throws IOException {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		int[] stevila = {0, 1, 2, 3, 6, 7, 8, 9}; 
		for (ArrayList<Integer> permutacija : permute(stevila)) {
			boolean ustrezna = true;
			
			BufferedReader vhod = new BufferedReader(new FileReader("p079_keylog.txt"));
			while (vhod.ready() && ustrezna) {
				String vrstica = vhod.readLine().trim();
				if (vrstica.equals("")) continue;
				
				char a = vrstica.charAt(0);
				char b = vrstica.charAt(1);
				char c = vrstica.charAt(2);

				
				
				if (permutacija.indexOf(Character.getNumericValue(a)) > permutacija.indexOf(Character.getNumericValue(b))) ustrezna = false;
				if (permutacija.indexOf(Character.getNumericValue(a)) > permutacija.indexOf(Character.getNumericValue(c))) ustrezna = false;
				if (permutacija.indexOf(Character.getNumericValue(b)) > permutacija.indexOf(Character.getNumericValue(c))) ustrezna = false;
				
				
			}
			vhod.close();
			
			if (ustrezna) result.add(permutacija);
		}
		
		return result;
	}
	
	public static ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	 
		//start from an empty list
		result.add(new ArrayList<Integer>());
	 
		for (int i = 0; i < num.length; i++) {
			//list of list in current iteration of the array num
			ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
	 
			for (ArrayList<Integer> l : result) {
				// # of locations to insert is largest index + 1
				for (int j = 0; j < l.size()+1; j++) {
					// + add num[i] to different locations
					l.add(j, num[i]);
	 
					ArrayList<Integer> temp = new ArrayList<Integer>(l);
					current.add(temp);
	 
					//System.out.println(temp);
	 
					// - remove num[i] add
					l.remove(j);
				}
			}
	 
			result = new ArrayList<ArrayList<Integer>>(current);
		}
	 
		return result;
	}
	
}
