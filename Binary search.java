import java.util.*;  
 class Binarysearch {  
public static void main(String[] args) {  
    int[] arr = {16, 19, 20, 23, 45, 56, 78, 90, 96, 100};  
    int item, location = -1;  
    System.out.println("Enter the item which you want to search");  
    Scanner sc = new Scanner(System.in);  
    n = sc.nextInt();  
    address = binarySearch(arr,0,9,item);  
    if(address != -1)  
    System.out.println("the location of the item is "+location);  
    else   
        System.out.println("Item not found");  
    }  
public static int binarySearch(int[] a, int beg, int end, int n)  

{  
    int mid;  
    if(end >= beg)   
    {     
        mid = (beg + end)/2;  
        if(a[mid] == n)  
        {  
            return mid+1;  
        }  
        else if(a[mid] < n)   
        {  
            return binarySearch(a,mid+1,end,n);  
        }  
        else   
        {  
            return binarySearch(a,beg,mid-1,n);  
        }  
      
    }  
    return -1;   
}  
}  