
import java.io.*; 

class SetCountBits { 
	/* Function to get no of set 
	bits in binary representation 
	of passed binary no. */
  
	static int SetCountBits(int n) 
	{ 
		int count = 0; 
		while (n != 0) { 
			n = n & (n-1);
			count++; 
		} 
		return count; 
	} 

	// main class
	public static void main(String args[]) 
	{ 
		int i = 9; 
		System.out.println(countSetBits(i)); 
	} 
} 

// time complexity of this code is O(logn)
// explanation for time complexity 
/* n =  9  
  we can write 9 in binary form as (1001)
   count = 0

   Since 9 > 0, subtract by 1 and do bitwise & with (9-1)
   n = 9&8  (1001 & 1000)
   n = 8
   count  = 1

   Since 8 > 0, subtract by 1 and do bitwise & with (8-1)
   n = 8&7  (1000 & 0111)
   n = 0
   count = 2

   Since n = 0, return count which is 2 now.
   */
