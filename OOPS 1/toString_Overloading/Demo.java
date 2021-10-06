package toString_Overloading;

public class Demo {
      public static void main(String[] args) 
      {
    	  Student s = new Student("ankita",30);
    	//  System.out.println(s);//o/p: com.ankita99.toStringOverloading.Student@15db9742
    	  System.out.println(s); 
      }

	
}

      class Student 
      {
         String name;
         int rollno;
         
         Student(String name, int rollno)
         {
        	 this.name = name;
        	 this.rollno = rollno;
         }
         void show()
         {
        	 System.out.println(this.name);
        	 System.out.println(this.rollno);
         }
		
		public String toString() {
			
			return "{"+this.name+ ": "+ this.rollno+"}";
		}
         
      }

