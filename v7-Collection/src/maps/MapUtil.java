package maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MapUtil {

	public static void main(String[] args) {
		Map<String,Integer> mfi = new HashMap<>();
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			mfi.put(Math.random()*1000+"", rand.nextInt(10));
		}
		
		System.out.println(mfi);
		System.out.println(invert(mfi));
	}
	
	private static <K,V> Map<V,K> invert(Map<K,V> mapIn){
		Map<V,K> mapOut = new HashMap<V, K>();
		for (Map.Entry<K, V> entry: mapIn.entrySet()) {
			mapOut.put(entry.getValue(), entry.getKey());
		}
		return mapOut;
	}

}
