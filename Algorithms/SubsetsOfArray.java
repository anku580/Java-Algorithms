import java.util.*;
import java.lang.*;
import java.io.*;
 
public class SubsetsOfArray
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		for(int i=0;i<(1<<n);i++){
			System.out.print("{ ");
			for(int j=0;j<n;j++){
				if((i&(1<<j))>0){
					System.out.print(arr[j]+" ");
				}
			}
			System.out.println("}");
		}
	}
}