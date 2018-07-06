package thrymr.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Hashmap {
	public static void main(String[] args) {
		
		Map<Integer,String> map=new HashMap<Integer,String>();
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		map.put(1,"prem");
		map.put(2,"eqweqweq");
		map.put(3,"referereada");
		Set set = map.entrySet();
		Iterator itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(map.get(itr));
			
		}
		
	}

}
