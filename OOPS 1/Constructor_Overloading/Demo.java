package Constructor_Overloading;

public class Demo {

	int x,y;
	Demo(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	Demo()
	{
		this.x = 12;
		this.y = 13;
	}
	public static void main(String[] args)
	{
		Demo demo = new Demo(45,34);
		System.out.println(demo.x);
		System.out.println(demo.y);
		
		Demo demo1 = new Demo();
		System.out.println(demo1.x);
		System.out.println(demo1.y);
	}
	
}
