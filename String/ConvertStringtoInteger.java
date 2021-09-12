package String;

public class ConvertStringtoInteger {

	public static void convert( String s ) {
		
	String strarr[] = {"One","1", "Two","2", "Three","3", "Four","4", "Five","5", "Six","6", "Seven","7", "Eight","8", "Nine","9", "Ten","10",
    "Eleven","11","Twelve","12", "Thirteen","13", "Fourteen","14", "Fifteen","15","Sixteen","16","Seventeen","17", "Eighteen","18", "Nineteen","19",
    "Twenty","20","Thrity","30","Fourty","40","Fifty","50","Sixty","60","Seventy","70","Eighty","80","Ninty","90","Hundred","100","Thousand","1k","lakh","100k","Crore","100M"};
		 for ( int i = 0; i < strarr.length-1; i++ ) {
			 
			 if ( s.equals(strarr[i])) {
				 
				 System.out.println(strarr[i+1]);
				 break;
			 }
		 }
	}
	public static void main(String[] args) {
		
		String s = "Twenty";

		
		convert(s);
	}

}
