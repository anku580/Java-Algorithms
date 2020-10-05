import java.util.Scanner;


/* Longest Common Subsequence problem implementation using Dynamic Programming */

public class LongestCommonSubsequence 
{ 
  
  /* Calculates and returns the LCS for X[0..m-1], Y[0..n-1] */
  int lcs( char[] X, char[] Y, int m, int n ) 
  { 
    int L[][] = new int[m+1][n+1]; 
  
    for (int i=0; i<=m; i++) 
    { 
      for (int j=0; j<=n; j++) 
      { 
        if (i == 0 || j == 0) 
            L[i][j] = 0; 
        else if (X[i-1] == Y[j-1]) 
            L[i][j] = L[i-1][j-1] + 1; 
        else
            L[i][j] = max(L[i-1][j], L[i][j-1]); 
      } 
    } 

  return L[m][n]; 
  } 
  
  // to calculate the maximum of two integers
  int max(int a, int b) 
  { 
    return (a > b)? a : b; 
  } 
  
  public static void main(String[] args) 
  { 
    LongestCommonSubsequence lcs = new LongestCommonSubsequence(); 
    
    Scanner obj = new Scanner(System.in);
    System.out.println("Enter string X : ");
    String s1 = obj.nextLine(); 
    System.out.println("Enter string Y : ");
    String s2 = obj.nextLine();
  
    char[] X=s1.toCharArray(); 
    char[] Y=s2.toCharArray(); 
    int m = X.length; 
    int n = Y.length; 
  
    System.out.println("Length of LCS is" + " " + lcs.lcs( X, Y, m, n ) ); 
  } 
  
} 
  

/* 

Sample Input :

Enter X : AGGTAB
Enter Y : GXTXAYB

Sample Output :

Length of LCS is 4

Time Complexity : O(N * M), where N and M are the lengths of two given Strings X and Y.

*/