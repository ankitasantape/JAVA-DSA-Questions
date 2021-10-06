package Nested_Classes;

public class Outer {

	static int a = 20;

	int b = 90;
	
	public static void display()
	{
		System.out.println(a);
	}
	//static inner class can access outer's static variable but it cann't access non-static variable & methods of outer class directly 
	//To do so create object of outer class
	static class Inner
	{
		Inner()
		{
			System.out.println("This is inner constructor...");
			System.out.println("Vaue of a from inside inner class "+a); // static variable
		//	System.out.println(b);//Non-static variable
			
		}
		public void test()
		{
			display();
			System.out.println(a);
		}
	}
	public static void main(String[] args) {
		System.out.println(Outer.a);
				Outer.display();
		//static inner class object
	//	OuterClass.InnerClass variable = new OuterClass.InnerClass();
		Outer.Inner obj = new Outer.Inner(); 
		obj.test();
		Inner t   = new Inner();
		t.test();
	}
}
