import java.util.*;
class ReverseString
{
    public static void main(String args[])
    {
        String originalString, reverseString = "";
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string to reverse : ");
        originalString = input.nextLine();

        int length = originalString.length();

        for (int i = length - 1 ; i >= 0 ; i--){
            reverseString = reverseString + originalString.charAt(i);

        }

        System.out.println("Reverse of the string: " + reverseString);
    }
}