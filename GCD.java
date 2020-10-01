public class gcd
{
    // Recursive function to return gcd of a and b
    static int gcd(int a, int b)
    {
        
        if (a == 0)
          return b;
        if (b == 0)
          return a;
      
        // base case
        if (a == b)
            return a;
      
        // a is greater
        if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a);
    }
     
    // Driver method
    public static void main(String[] args) 
    {
        
        System.out.println(gcd(40,5));
                System.out.println(gcd(48,56));

        
        
       } 
       
}
