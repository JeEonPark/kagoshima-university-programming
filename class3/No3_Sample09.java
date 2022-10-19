/*
  プログラミング言語II 及び演習
    No3_Sample09
*/

import java.lang.*;
import java.util.Scanner;

public class No3_Sample09 {

	public static void main(String[] args) {
		
		int a = 0;
		int b = 0;
		System.out.print("A?   ");
		Scanner s1 = new Scanner(System.in);
		String str1 = s1.nextLine();
		
		System.out.print("B?   ");
		Scanner s2 = new Scanner(System.in);
		String str2 = s2.nextLine();
		
 		try{
			a = Integer.parseInt( str1 );
			b = Integer.parseInt( str2 );
		} catch( NumberFormatException e ){
			System.out.println("引数は整数値で与えてください");
			System.exit( -1 );
		}
		
		String str = a>b ? "A":"B";
		System.out.println( str + "  が大きいです" );
		
	}
}
