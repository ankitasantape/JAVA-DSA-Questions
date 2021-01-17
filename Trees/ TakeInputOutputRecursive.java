package com.treesLearning;

import java.util.Scanner;
/*
 Whenever u r going to solve tree problem just imagine tree like this
    root     <--- head, we have to handle base case and remaining problem will be solved by recursion
   / | \
  /  |  \
/ \ / \ / \  <--- 3no small subtree ka ans collect krke whole subtree ke liye ans find krna hai, jo bhi small problem hai recursively solve kro & base case will be handle by us  
   
Input:
Enter next node data: 
4
Enter number of children for 4
3
Enter next node data: 
2
Enter number of children for 2
0
Enter next node data: 
1
Enter number of children for 1
2
Enter next node data: 
5
Enter number of children for 5
0
Enter next node data: 
6
Enter number of children for 6
0
Enter next node data: 
3
Enter number of children for 3
0
Output:
4:2,1,3,  ( Root - 4 , Children of 4 - 2,1,3 )                         4
2:        ( Root - 2 , Children of 2 - 0     )                        /|\
1:5,6,    ( Root - 1 , Children of 1 - 5,6   )                       2 1 3
5:        ( Root - 5 , Children of 5 - none  )                        / \ 
6:        ( Root - 6 , Children of 5 - none  )                       5   6
3:        ( Root - 3 , Children of 5 - none  ) 
		we can avoid this type of input by using scanner in main function or out of takeInput() function
		we can give input likewise  4 3 2 0 1 2 5 0 6 0 3 0 instead of given above input line-by-line for that we should use scanner in main class or anywhere else, scanner should be used outside the takeInput() function otherwise it'll create problem
		if we enter input, 
		Input:
        Enter next node data: 4 3 2 0 1 2 5 0 6 0 3 0
        Enter number of children for 4
        Enter next node data: 
        ...Agar hum scanner inside takeInput() lete hai toh every time new scanner call hoga toh every time Enter next node data: print hoga but previous scanner contains all this input agar koi usse data mange ga to it will give 4 3 2 0 1 2 5 0 6 0 3 0 but new scanner can not access this data
        so we can resolve this issue ek to scanner ko bar bar call na kro aur scanner ko takeInput() fun ke bahar initialize kro n takeInput(Scanner s) me use kro nahi to at time whole input na do one-by-one input kro 
        When we use scanner from outside source then we r not going create every time new scanner,
Input:
Enter next node data: 4 3 2 0 1 2 5 0 6 0 3 0
Enter number of children for 4
Enter next node data: 
Enter number of children for 2
Enter next node data: 
Enter number of children for 1
Enter next node data: 
Enter number of children for 5
Enter next node data: 
Enter number of children for 6
Enter next node data: 
Enter number of children for 3

Output:
4:2,1,3,  ( Root - 4 , Children of 4 - 2,1,3 )                         4
2:        ( Root - 2 , Children of 2 - 0     )                        /|\
1:5,6,    ( Root - 1 , Children of 1 - 5,6   )                       2 1 3
5:        ( Root - 5 , Children of 5 - none  )                        / \ 
6:        ( Root - 6 , Children of 5 - none  )                       5   6
3:        ( Root - 3 , Children of 5 - none  ) 


*/
public class TakeInputOutputRecursive {

	public static TreeNode<Integer> takeInput(Scanner s) {

		int rootdata;
		//Scanner s = new Scanner(System.in);
		//System.out.println("Enter next node data: ");
		rootdata = s.nextInt();
		
		TreeNode<Integer> root = new TreeNode<>(rootdata);
		
		//System.out.println("Enter number of children for " + n);
		
		int childCount = s.nextInt(); 
		
		for ( int i = 0; i < childCount; i++ ) { 
			// Call takeInput() for each individual child of curr root
			TreeNode<Integer> child = takeInput(s);
			root.children.add(child);
		}
		// 2 ke childCount 0 hai to directly 2 return kr denge aur 2 return krke 4 ke pas jayega n 4 append kr lega 2 ko and same for 5,6 & 3 also
		return root;
	}
	
	public static void print(TreeNode<Integer> root ) {
		
		String s = root.data + ":"; // 4 2
		// go to each and every child of its root
		for ( int i = 0; i < root.children.size(); i++ ) { // 2 ke liye is for loop me nhi aayenge aur 2: print kr denge , 1 ke liye aayenge
			
			// append every children data at ith position with rootdata 
			s = s + root.children.get(i).data +","; 
		}
		System.out.println(s); // rootdata : child1, child2, child3  4:2,1,3,   2:   , 1:5,6 , 5: , 6:, 3: 
		
		// firse ek ek child pe jayenge aur uspe print call krenge qki hume child ke child bhi print krna hai
		for ( int i = 0; i < root.children.size(); i++ ) { //4 ke liye es loop me aayenge 2,1,3 pe print() call krenge, 2 ko zero child hai to es loop me nhi aayenge, 1 ko 2 child hai to es loop me aayenge 5 & 6 pe print() call krenge
			print(root.children.get(i));
		}
		
	}
	public static void main(String[] args) {
		
//		TreeNode<Integer> root= new TreeNode<>(4);
//		TreeNode<Integer> node1 = new TreeNode<>(2);
//		TreeNode<Integer> node2 = new TreeNode<>(3);
//		TreeNode<Integer> node3 = new TreeNode<>(5);
//		TreeNode<Integer> node4 = new TreeNode<>(6);
//		
//		root.children.add(node1);
//		root.children.add(node2);
//		root.children.add(node3);
//		
//		node2.children.add(node4);
//		
//		System.out.println(root);
		
		Scanner s = new Scanner(System.in);
		
		TreeNode<Integer> input = takeInput(s);
		
		print(input);
		
		/* First, we r going to make takeInput() which will give root of whole subtree 
		   TreeNode<Integer> input = takeInput();
		   
		   In takeInput() function, first collect the data of root then scan for no of childrens of root, how many childrens of root? childCount = ? 
		   if root.data = 1 hai and NoOfChildOfRoot = 3 hai to hume 3times takeInput() call krenge aur 3no children ka data mil jayega means hume next 3 subtree ka data user se input lena hai     
		
		    TreeNode<Integer> takeInput(){
		         
		         Scanner sc = new Scanner(System.in);
		         int rootdata = sc.nextInt();
		         
		         // Create new treeNode of rootdata
		        
		         TreeNode<Integer> root = new TreeNode<>(rootdata);
		        
		         int childCount = sc.nextInt();
		         
		         for( int i = 0; i < childCount; i++){
		             TreeNode<Integer> child = takeInput();
		             root.children.add(child);
		         }
		         
		         return root;
		    }
		*/
	}

}
