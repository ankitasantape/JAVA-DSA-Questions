package Nested_Classes;

public class ClassA {

	class ClassInner
	{
		String city = "Los Angeles";
		public void showCity()
		{
			System.out.println("City is "+city);
		}
	}
	int a = 90;
	static String str = "Google";
	
	public void displayA()
	{
		System.out.println(a);
	}
	
}
