 class binaryPalindrome 
{ 
  
    static int isKthBitSet(long x, long k)  
    {  
        int rslt = ((x & (1 << (k - 1))) != 0) ? 1 : 0;  
        return rslt; 
    }  
      
    static int isPalindrome( long x)  
    {  
        long l = 1; // Initialize left position  
        long r = (Integer.SIZE/8 )* 8; // initialize right position  
      
 
        while (l < r)  
        {  
            if (isKthBitSet(x, l) != isKthBitSet(x, r))  
            { 
                return 0;  
            } 
            l++; r--;  
        }  
        return 1;  
    }  
      
    public static void main (String[] args) 
    {  
        long x = 1 << 15 + 1 << 16 ;  
        System.out.println(isPalindrome(x));  
          
        x = (1 << 31) + 1 ;  
        System.out.println(isPalindrome(x));  
    }  
} 
