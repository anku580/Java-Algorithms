import java.util.*; 

class sortmapKey { 

	static Map<String, Integer> map = new HashMap<>(); 

	public static void sortbykey() 
	{ 
		TreeMap<String, Integer> sorted = new TreeMap<>(map); 

		for (Map.Entry<String, Integer> entry : sorted.entrySet()) 
			System.out.println("Key = " + entry.getKey() + 
						", Value = " + entry.getValue());		 
    } 
    
	public static void main(String args[]) 
	{ 
		map.put("Jayant", 80); 
		map.put("Abhishek", 90); 
		map.put("Anushka", 80); 
		map.put("Amit", 75); 
		map.put("Danish", 40); 
		sortbykey(); 
	} 
} 
