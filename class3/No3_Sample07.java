/*
  プログラミング言語II 及び演習
    No3_Sample07
*/

import java.lang.*;
import java.util.Scanner;

public class No3_Sample07 {

	public static void main( String args[] ){

		int a = 0;
		int sum = 0;
		// int counter = 1;
		
		System.out.print("A?   ");
		Scanner s1 = new Scanner(System.in);
		String str1 = s1.nextLine();
		
				
 		try{
			a = Integer.parseInt( str1 );
		} catch( NumberFormatException e ){
			System.out.println("引数は整数値で与えてください");
			System.exit( -1 );
		}
		
		int counter = 1;
		while ( counter <= a ){
			sum += counter;
			counter++;
		}
		
		System.out.println("1+2+3+・・・+ " + str1 + " = " + sum);
	}
}
