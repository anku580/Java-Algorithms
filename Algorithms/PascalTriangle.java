import java.util.*;
import java.lang.*;
import java.io.*;
 
public class PascalTriangle
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m[] = new int[100];
		m[0] = 1;
		int p = n;
		for(int i=0;i<n;i++){
			for(int k=p;k>=1;k--){
				System.out.print(" ");
			}
			for(int j=0;j<=i;j++){
				System.out.print(m[j]+" ");
			}
			System.out.println();
			p--;
			for(int j=i+1;j>0;j--){
				m[j] = m[j] + m[j-1];
			}
		}
	}
}