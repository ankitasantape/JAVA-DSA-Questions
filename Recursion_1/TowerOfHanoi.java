package Recursion_1;
/*                                             Tower of Hanoi

Tower of Hanoi is a mathematical puzzle where we have three rods and n disks. 
The objective of the puzzle is to move all disks from source rod to destination rod using third rod (say auxiliary). 
The rules are :
1) Only one disk can be moved at a time.
2) A disk can be moved only if it is on the top of a rod.
3) No disk can be placed on the top of a smaller disk.
Print the steps required to move n disks from source rod to destination rod.
Source Rod is named as 'a', auxiliary rod as 'b' and destination rod as 'c'.
Input Format :
Integer n
Output Format :
Steps in different lines (in one line print source and destination rod name separated by space)
Constraints :
0 <= n <= 20
Sample Input 1 :
2
Sample Output 1 :
a b
a c
b c
Sample Input 2 :
3
Sample Output 2 :
a c
a b
c b
a c
b a
b c
a c*/
public class TowerOfHanoi {
    public static void towerOfHanoi(int disks, char source, char auxiliary, char destination) {
		
    	if(disks == 0) { return; }
    	if(disks == 1)
		{
			//System.out.println("Disk"+disks+" is moving from "+source +" to "+destination);
			System.out.println(source + " " + destination);
			return;
		}
		    towerOfHanoi(disks - 1, source, destination, auxiliary);
			     // System.out.println("Disk "+(disks - 1)+" is moving from "+source + " to " + destination);
			      
		    System.out.println(source + " " + destination);
		    
		    towerOfHanoi(disks - 1, auxiliary,source, destination);
	}
	public static void main(String[] args) {
           int n = 3;
           char source = 'a';
           char aux = 'b';
           char desti = 'c';
           
           towerOfHanoi(n, source, aux, desti);
		
	}

}
