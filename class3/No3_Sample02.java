/*
  プログラミング言語II 及び演習
    No3_Sample02
*/

import java.lang.*;

class test01 {
	public int a;
	public double b;
	test01(){
		a = 1;
		b = 3.141592;
	}
}

class test02 {
	public String str;
	test02(){
		str = "Hello";
	}
}

public class No3_Sample02 {

	public static void main( String args[] ){
		Object t01 = new test01();

		if ( t01 instanceof test01 ){
			System.out.println("test01と同じ型です");
		}else {
				System.out.println("型が異なります");
		}
	}
}
