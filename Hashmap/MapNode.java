package hashMap;

public class MapNode< K, V > {
       
	K key;
    V value;
    MapNode< K, V > next;
     
    public MapNode(K key, V value) {
   		super();
   		this.key = key;
   		this.value = value;
   	}
       
}
