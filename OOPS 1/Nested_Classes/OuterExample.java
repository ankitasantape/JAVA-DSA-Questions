package Nested_Classes;

public class OuterExample {

	int a =89;
	private int b = 67;
	static int c = 98;
	//member inner class inside class but outside method
	class InnerExample
	{
		public void doSum(){
			System.out.println("Sum is "+(a+b+c));
		}
	}
	
	public static void main(String[] args) {
		//Outer Object
		
		OuterExample outer = new OuterExample();
		
		//Inner Object
		
		OuterExample.InnerExample obj = outer.new InnerExample();
		
		obj.doSum();
		
		OuterExample.InnerExample obj1 = new OuterExample().new InnerExample();
		
		obj1.doSum();
	}
}
