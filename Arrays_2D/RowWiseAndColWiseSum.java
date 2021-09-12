package Arrays_2D;

public class RowWiseAndColWiseSum {
	static void row_sum(int arr[][]) 
	{ 
	    int m = arr.length, n = arr[0].length;
	    int i,j; 
	    int largeR = Integer.MIN_VALUE, rowindex = 0, rowsum = 0;
	   
	    for (i = 0; i < m; ++i) { 
	        for (j = 0; j < n; ++j) { 
	  
	            rowsum = rowsum + arr[i][j]; 
	            
	            if( rowsum > largeR )
				{
					largeR = rowsum;
					rowindex = i;
				}
	        } 
	  
	        
	        rowsum = 0; 
	    } 
	    System.out.println( "Sum of the row "
	            + rowindex + " = " + largeR ); 
	} 
	  
	
	static void column_sum(int arr[][]) 
	{ 
		int m = arr.length, n = arr[0].length;
	    int i,j; 
		int largeC = Integer.MIN_VALUE, colindex = 0, colsum = 0;

	    
	    for (i = 0; i < n; ++i) { 
	        for (j = 0; j < m; ++j) { 
	             
	            colsum = colsum + arr[j][i];
	            
	            if ( colsum > largeC)
				{
					largeC = colsum;
					colindex = i;
				} 
	         } 
	        colsum = 0; 
	    } 
	    System.out.println( 
	             "Sum of the column "
	            + colindex+ " = " + largeC ); 
	  
	} 

	public static void main(String[] args) {
		int arr[][] = {{6 ,9},
			{8, 5}, 
			{9, 2}};
//		int arr[][] = {
//				{1, 2},
//				{90, 100},
//				{3, 40},
//				{-10, 200}
//		};
		row_sum(arr);
		column_sum(arr);
	}

}
