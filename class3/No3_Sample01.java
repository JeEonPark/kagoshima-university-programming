/*
  プログラミング言語II 及び演習
    No3_Sample01
*/

import java.lang.*;

public class No3_Sample01 {

	public static void main( String args[] ){
		int a = 0;
		int b = 1;
		
		if ( args.length != 2 ){
			System.out.println("引数を２つ指定してください");
			System.exit( -1 );
		}
		
		try{
			a = Integer.parseInt( args[0] );
			b = Integer.parseInt( args[1] );
		} catch( NumberFormatException e ){
			System.out.println("引数は整数値で与えてください");
			System.exit( -1 );
		}

		int c = a % b;
		int d = (a-c)/b;
		
		System.out.println( a + " ÷ " + b + " = " + d + " ... " + c );
	}
	
}
