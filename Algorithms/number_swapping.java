import java.util.Scanner;

public class number_swapping {

    public static void main(String[] args){

        int  a ,b ;
        Scanner input = new Scanner (System.in);
        a = input.nextInt();
        b= input.nextInt();

        System.out.println("Before Swap");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        int temp = a;
        a = b;
        b = temp;

        System.out.println("After swap");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

    }

}
