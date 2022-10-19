/*
  プログラミング言語II 及び演習
    No3_Sample05
*/

import java.lang.*;
import java.util.Scanner;

public class No3_Sample05 {

	public static void main(String[] args) {
		
		int a = 0;
		int b = 0;
		System.out.print("A?   ");
		Scanner s1 = new Scanner(System.in);
		String str1 = s1.nextLine();
		
		System.out.print("B?   ");
		Scanner s2 = new Scanner(System.in);
		String str2 = s2.nextLine();
		System.out.println(str2);
		
 		try{
			a = Integer.parseInt( str1 );
			b = Integer.parseInt( str2 );
		} catch( NumberFormatException e ){
			System.out.println("引数は整数値で与えてください");
			System.exit( -1 );
		}
		
		if (a > b ){ 
			System.out.println( "１番目の数値の方が大きいです");
		} else if ( a == b ){
			System.out.println( "同じ値です");
		} else {
			System.out.println( "２番目の数値の方が大きいです");
		}
		
	}
}
