package hashMap;

public class OurMapUse {

	public static void main(String[] args) {
		Map<String , Integer> map = new Map<>();
		for( int i = 0; i < 20; i++ ) {
			map.put("abc" + i, 1 + i );
			System.out.println("i = " + i + " If = " + map.loadfactor());
		}
		
		map.removeKey("abc3");
		map.removeKey("abc19");
		for( int i = 0; i < 20; i++ ) {
			System.out.println("abc" + i + ":" + map.getValue("abc"+i));
		}
	}

}
