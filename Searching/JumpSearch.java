package searching;
import java.util.*;
public class JumpSearch 
{
    public static void main( String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter the elements of the sorted array");
        for(int i=0; i<n; i++)
        {
            a[i] = sc.nextInt();
        }
        System.out.println("Enter the element to be searched");
        int m = sc.nextInt();

        int pos =-1;

        int size = (int) Math.sqrt(n);
        int jump = size;

        /*Iterate till the array ends */
        while(jump < n)
        {
            if(a[jump] == m)
            {
                pos = jump;
                break;
            }
            else if(a[jump] < m)
            {
                jump = jump + size;
            }
            else
            {
                /*If element at jump position becomes larger jump back once and then perform linear search between the two jump positions. */
                for(int i=jump-size; i<jump; i++)
                {
                    if(a[i]==m)
                    {
                        pos = i;
                        break;
                    }
                }
            }
        }

        if(pos == -1)
        {
            System.out.println("Element not found");
        }
        else
        {
            pos = pos + 1;
            System.out.println("Element found at " + pos + " position");
        }

        sc.close();
    }
    
}