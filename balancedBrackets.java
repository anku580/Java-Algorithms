import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class balancedBrackets {

    // Complete the isBalanced function below.
    static String isBalanced(String s) throws Exception {
        Stack<Character> st=new Stack<>();
        int n=s.length();
        if(n%2!=0)return "NO";
        for(int i=0;i<n;i++){
            char x=s.charAt(i);
            try{
            if(x=='('||x=='{'||x=='[')st.push(x);
            else if(x==')'&& st.peek()=='(')st.pop();
            else if(x=='}'&& st.peek()=='{')st.pop();
            else if(x==']'&& st.peek()=='[')st.pop();
            else st.push(x);
            }
            catch(Exception e){
                return "NO";
            }
        }
        if(st.isEmpty())return "YES";
        else 
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();
            
            String result = isBalanced(s);
            
            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
