package String;

public class ReverseString {
	
	public static void main(String[] args) {
		String str = "Welcome to Coding Ninjas";
		// output: sajniN gnidoC ot emocleW
		char[] temparray = str.toCharArray();
        int left, right = 0;
        right = temparray.length - 1;
 
        for (left = 0; left < right; left++, right--) {
            // Swap values of left and right
            char temp = temparray[left];
            temparray[left] = temparray[right];
            temparray[right] = temp;
        }
 
        for (char c : temparray)
            System.out.print(c);
        System.out.println();

	}

	

}
