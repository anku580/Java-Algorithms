import java.io.*; 
import java.util.*; 
// User defined node class 
class Node { 
      int data; 
      Node left, right; 
         
      // Constructor to create a new tree node 
      Node(int key)  
      { 
           data  = key; 
           left = right = null; 
      } 
} 
class SumOfOddEvenLevelNodes { 
      // return difference of  
      // sums of odd level  and even level  
      static int evenOddLevelDifference(Node root) 
      { 
             if (root == null) 
                 return 0; 
  
             // create a queue for  
             // level order traversal 
             Queue<Node> q = new LinkedList<>(); 
             q.add(root); 
  
             int level = 0;  
             int evenSum = 0, oddSum = 0; 
  
             // traverse until the  
             // queue is empty 
             while (q.size() != 0) { 
                   int size = q.size(); 
                   level++; 
                     
                   // traverse for complete level  
                   while (size > 0) { 
                          Node temp = q.remove(); 
  
                          // check if level no.  
                          // is even or odd and  
                          // accordingly update  
                          // the evenSum or oddSum  
                          if (level % 2 == 0) 
                              evenSum += temp.data; 
                          else
                              oddSum += temp.data; 
  
                          // check for left child  
                          if (temp.left != null) 
                              q.add(temp.left); 
                             
                          // check for right child  
                          if (temp.right != null) 
                              q.add(temp.right); 
                          size--; 
                   } 
             } 
             return (oddSum - evenSum);   
      } 
  
      // Driver code 
      public static void main(String args[]) 
      { 
             // construct a tree 
             Node root = new Node(5); 
             root.left = new Node(2); 
             root.right = new Node(6); 
             root.left.left = new Node(1); 
             root.left.right = new Node(4); 
             root.left.right.left = new Node(3); 
             root.right.right = new Node(8); 
             root.right.right.right = new Node(9); 
             root.right.right.left = new Node(7); 
  
             System.out.println("diffence between sums is " +  
                                evenOddLevelDifference(root)); 
      } 
} 
