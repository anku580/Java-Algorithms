package Algorithms;

import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int year = scan.nextInt();

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println("Leap");
        } else {
            System.out.println("Regular");
        }
    }
}
