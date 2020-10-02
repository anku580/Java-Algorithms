import java.util.*;

class BalancedBrackets{

    public static String balancedBracket(String exp){

        Stack<Character> s = new Stack<Character>();
        int flag =0;
        
        for(int i=0; i<exp.length(); i++)
        {
            char ch = exp.charAt(i);
            /*If opening bracket is encountered then it is pushed in the stack */
            if((ch=='(') || (ch=='[') || (ch=='{'))
            {
                s.push(ch);
                continue;
            }

            /*If closing bracket is encountered then if its corresponding pair bracket is not at top of stack then value of flag is changed and loop is terminated */
            if((ch==')') || (ch==']') || (ch=='}'))
            {
                if(ch == ')' && s.peek() != '(')
                {
                    flag =1;
                    break;
                }

                if(ch == ']' && s.peek() != '[')
                {
                    flag =1;
                    break;
                }

                if(ch == '}' && s.peek() != '{')
                {
                    flag =1;
                    break;
                }
            }
        }

        String st;

        /*Check flag value to know whether loop terminated normally or abruptly in between */
        if(flag == 0)
        {
            st = "balanced";
        }
        else
        {
            st = "not balanced";
        }

        return st;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the expression : ");
        String s = sc.nextLine();
        
        String ans = balancedBracket(s);

        System.out.println("Given expression is " + ans + " in terms of brackets");

        sc.close();
    }
}