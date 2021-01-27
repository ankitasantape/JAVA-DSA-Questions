package hashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicates {

	public static ArrayList<Integer> removeDuplicates( int []a ){
		
		ArrayList<Integer> output = new ArrayList<>();
		HashMap<Integer, Boolean> exist = new HashMap<>();
		
		for( int i = 0;i < a.length; i++ ) {
			// if integer is already present then skip
			if( exist.containsKey(a[i])) {
				
				continue;
			}
			// if integer is not present in array then insert integer into arrayList 
			output.add( a[i] );
			// if element does not exist in map then insert it into map and mark as true 
			exist.put(a[i], true);
		}
		
		return output;
	}
	
	public static void main(String[] args) {
		
		int a[] = {1,2,4,3,5,1,2,6,6};
		
		ArrayList<Integer> output = removeDuplicates( a );
		
		for( int i : output ) {
			
			System.out.println(i);
		}
	}

}
