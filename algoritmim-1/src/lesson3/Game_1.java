package lesson3;

import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;


// simple algorithem. odd and even
public class Game_1 {
	
	

	public static void letsPlay (int arr[], boolean flag)	
	{
		char move;
		int i=0; 
		int j=0;
		Arrays.toString(arr);
		System.out.println("l play first");
		
		if (flag)
		
				System.out.print("my move is- L ");
			else
				System.out.print("my move is- R ");
			
		System.out.println("press R or L");
		
		System.out.print("your move is- ");
		
		
	}

	public static void main(String[] args) {
		
		// array deceleration and input
		int[] arr= new int [10];
		for (int i=0; i<arr.length; i++)
			arr[i]= (int)(Math.random()*10);
		
		int zugi=0;
		int ezugi=0;
		boolean flag=false; // if zugi>ezugi flag=true
		
		for (int i=0; i<arr.length; i+=2)
		{
			zugi+=arr[i];
			ezugi+=arr[i+1];
		}
		
		if (zugi>ezugi) flag=true;
		
		
		
		
		
	
}
}
