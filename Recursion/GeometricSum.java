package Recursion;

public class GeometricSum {
	public static double findGeometricSum(int k){

		if( k == 0)
		{
			return 1;
		}
		double ans = 1 / Math.pow(2, k ) + findGeometricSum(k - 1 );
		return ans ;
	}
	
	public static void main(String[] args) {
        int k = 3;
        double ans = findGeometricSum(k);
        System.out.println(ans);
	}

}
