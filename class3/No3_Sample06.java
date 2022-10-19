/*
  プログラミング言語II 及び演習
    No3_Sample06
*/

import java.lang.*;
import java.util.Scanner;

public class No3_Sample06 {

	public static void main( String args[] ){

		int a = 0;
		int sum = 0;
		System.out.print("A?   ");
		Scanner s1 = new Scanner(System.in);
		String str1 = s1.nextLine();
		
				
 		try{
			a = Integer.parseInt( str1 );
		} catch( NumberFormatException e ){
			System.out.println("引数は整数値で与えてください");
			System.exit( -1 );
		}
		
		for ( int i = 1; i <= a; i++ ){
			sum += i;
		}
		
		System.out.println("1+2+3+・・・+ " + str1 + " = " + sum);
	}
}
