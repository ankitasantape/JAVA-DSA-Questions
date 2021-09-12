package Arrays_2D;

public class RotateArrayClockwise {
    public static void rotateArray(int a[][])
    {
    	int minr = 0, maxr = a.length - 1, minc = 0, maxc = a[0].length - 1;
    	int prev = 0, curr = 0;
    	int count = 0, total = a.length * a[0].length;  
    	while(count < total-1)
    	{
    		if(minr + 1 == maxr || minc + 1 == maxc)
    		{
    			break;
    		}
    		prev = a[minr + 1][minc];
    		//Top row
    		//if(minc != maxc) {
    		for(int i = minc; i <= maxc && count < total-1  ; i++)
    		{
    			count++;
    			curr = a[minr][i];
    			a[minr][i] = prev;
    			prev = curr;
    			
    		}
    		//}
    		minr++;
    		//Right Column
    		for(int i = minr; i <= maxr && count < total - 1; i++)
    		{
    			count++;
    			curr = a[i][maxc];
    			a[i][maxc] = prev;
    			prev = curr;
    			
    		}
    		maxc--;
    		//Bottom row 
    		
    		for(int i = maxc; i >= minc && count < total-1
    				; i--)
    		{
    			count++;
    			curr = a[maxr][i];
    			a[maxr][i] = prev;
    			prev = curr;
    			
    		} 
    		
    		maxr--;
    		//System.out.println(maxr);
    		//Left Column
    	
    		for(int i = maxr; i >= minr && count < total-1; i--)
    		{
    			count++;
    			curr = a[i][minc];
    			a[i][minc] = prev;
    			prev = curr;
    			
    		}
    		System.out.println(minc);
    		minc++;
    		
    		
    	}
    	 for(int i = 0; i < a.length; i++)
         {
         	for(int j = 0; j < a[0].length; j++)
         	{
         		System.out.print(a[i][j]+" ");
         	}
         	System.out.println();
         }
 	
    }
	public static void main(String[] args) {
        int a[][] = {  {1 ,2 ,3 ,4 ,5 },
        		       {6 ,7 ,8 ,9 ,10},
        		       {11,12,13,14,15},
        		       {16,17,18,19,20},
        		       {21,22,23,24,25}  };
       rotateArray(a);
	}
}
