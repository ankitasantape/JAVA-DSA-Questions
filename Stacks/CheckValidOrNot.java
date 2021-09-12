package Stacks;

public class CheckValidOrNot {
    
	public static boolean check( String s ) {
		
		if ( s.length() % 2 != 0 ) {
			
			return false;
		}
		int o = 0, c = 0;
		
		for ( int i = 0; i < s.length(); i++ ) {
			
			if (s.charAt(i) == '{' ) {
				
				o += 1;
			
			} else {
				
				c += 1;
			}
		}
		
		if ( o == c ) {
			
			return true;
		}
		
		if ( o % 2 != 0 && c % 2 != 0 ) {
			
			return true;
		}
		
		if ( o % 2 == 0 && c % 2 != 0 ) {
			
			return false;
		}
		
		if ( o % 2 != 0 && c % 2 == 0 ) {
			
			return false;
		}
		
		if ( o % 2 == 0 && c % 2 == 0 ) {
			
			return true;
		}
		return false;
		
	}
	public static void main(String[] args) {
		
		String s = "{{{{}"; // Output : false
		
		boolean ans = check(s);
		
		System.out.println(ans);

	}

}
