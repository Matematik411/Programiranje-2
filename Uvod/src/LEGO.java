import java.util.HashMap;

public class LEGO {

	public static void main(String[] args) {
		HashMap<String, HashMap<String, Integer>> skatla1 = new HashMap<String, HashMap<String, Integer>>();
		HashMap<String, Integer> notranji4 = new HashMap<String, Integer>();
		notranji4.put("rdeca", 3);
		HashMap<String, Integer> notranji2 = new HashMap<String, Integer>();
		notranji2.put("rdeca", 1);
		notranji2.put("rumena", 5);
		
		skatla1.put("4x1", notranji4);
		skatla1.put("2x2", notranji2);
		
		HashMap<String, HashMap<String, Integer>> skatla2 = new HashMap<String, HashMap<String, Integer>>();
		HashMap<String, Integer> notranji24 = new HashMap<String, Integer>();
		notranji24.put("rumena", 3);
		notranji24.put("rdeca", 2);
		HashMap<String, Integer> notranji22 = new HashMap<String, Integer>();
		notranji22.put("rdeca", 1);
		notranji22.put("rumena", 1);
		HashMap<String, Integer> notranji28 = new HashMap<String, Integer>();
		notranji28.put("modra", 2);
		
		skatla2.put("4x1", notranji24);
		skatla2.put("2x2", notranji22);
		skatla2.put("8x1", notranji28);
		

		pretvori(skatla1, skatla2).entrySet().forEach(entry->{
			    System.out.println(entry.getKey() + " " + entry.getValue());  
		});
	}

	public static HashMap<String, HashMap<String, Integer>> pretvori(HashMap<String, HashMap<String, Integer>> prvi, HashMap<String, HashMap<String, Integer>> drugi) {
		for (String oblika : drugi.keySet()) {
			if (prvi.containsKey(oblika)) {
				
				for (String barva : drugi.get(oblika).keySet()) {
					if (prvi.get(oblika).containsKey(barva)) {
						int a = prvi.get(oblika).get(barva);
						a += drugi.get(oblika).get(barva);
						prvi.get(oblika).put(barva, a);
					} else {
						prvi.get(oblika).put(barva, drugi.get(oblika).get(barva));
					}
					
				}
				
			} else {
				prvi.put(oblika, drugi.get(oblika));
			}
		}
		return prvi;	
	}
}
