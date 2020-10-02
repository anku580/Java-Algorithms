import java.util.*;
import java.lang.*;
import java.io.*;

class LongestPallindromicSubsequenc{

    int max(int a, int b)
    {
        return (a>b ? a:b);
    }

    int LCS(int n, char[] arr, char[] b){

        int[][] dp=new int[n+1][n+1];

        for(int i=0;i<n;i=i+1){
            for(int j=0;j<n;j=j+1){
                dp[i][0]=0;
                dp[0][j]=0;
            }
        }

        for(int i=1;i<=n;i=i+1){
            for(int j=1;j<=n;j=j+1){
                if(arr[i-1]==b[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[n][n];
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int testcases=sc.nextInt();
        while(testcases-->0){
            String str=sc.next();
            int n=str.length();
            char[] arr=str.toCharArray();
            char[] b=new char[n];

            for(int i=0;i<n;i=i+1){
                b[i]=arr[n-i-1];
            }

            LongestPallindromicSubsequenc LPS=new LongestPallindromicSubsequenc();
            int result=LPS.LCS(n, arr, b);
            System.out.println(result);
        }
    }
}