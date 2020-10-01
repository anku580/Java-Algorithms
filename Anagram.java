import java.util.*;
import java.lang.*;
import java.io.*;

public class Anagram
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		boolean isAnagram = true;
		int al[] = new int[256];
		for(char c:a.toCharArray()){
			int index = (int)c;
			al[index]++;
		}
		for(char c:b.toCharArray()){
			int index = (int)c;
			al[index]--;
		}
		for(int i=0;i<256;i++){
			if(al[i]!=0){
				isAnagram=false;
				break;
			}
		}
		if (isAnagram){
			System.out.println("Anagram");
		}
		else{
			System.out.println("Not Anagram");
		}
	}
}