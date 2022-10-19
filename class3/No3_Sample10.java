/*
  プログラミング言語II 及び演習
    No3_Sample10
*/

import java.lang.*;

public class No3_Sample10 {

	public static void main(String[] args) {
		
		int num = 10;
 		int num_left = num << 1;
		int num_right = num >> 1;
		
		String str_num2 = Integer.toBinaryString( num );
		String str_left = Integer.toBinaryString( num_left );
		String str_right = Integer.toBinaryString( num_right );
		
		System.out.println("入力値  : "+ num + "    2進数 : " + str_num2);
		System.out.println("左シフト: "+ num_left + "    2進数 : " + str_left);
		System.out.println("右シフト: "+ num_right + "    2進数 : " + str_right);
		
	}
}
