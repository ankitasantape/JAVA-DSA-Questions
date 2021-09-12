package Arrays_2D;

public class Que1 {
    public static void ans(int input[][])
    {
    	for(int i = 0; i < 2*input.length ; i++)
        {
            int k = 0;
            for(int j = 0; j < input[0].length; j++)
            {
                
                System.out.print(input[i][k]);
                k++;
            }
            System.out.print(" ");
        }

    }
	public static void main(String[] args) {
		//int a[][] = {{},{},{}};
		

	}

}
