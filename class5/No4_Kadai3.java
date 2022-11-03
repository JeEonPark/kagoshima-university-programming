/*
 * プログラミング言語II及び演習
 *   No4_Sample12 --> No4_Kadai3
 *   
 */

import java.lang.*;
import java.util.Scanner;

public class No4_Kadai3 {
	
	// アプリケーション用のmainメソッド
	public static void main( String[] args ){
		
		// *****************************************
		//  ①配列の宣言など
		String[] month_sh = { "", "Jan", "Feb", "Mar", "Apr", "May", 
			"Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		int[] month_max = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		int year = 0;
		int month = 0;
		int day = 0;
		
		String s_year, s_day;
		
		// 改行コードの取得
        String nl = System.lineSeparator();
		
		while( true ){
			System.out.print( nl + "日付を8桁で入力してください：   ");
			Scanner s = new Scanner(System.in);
			String str = s.nextLine();
			
			// 文字数のチェック
			if ( str.length() != 8 ){
				System.out.println(nl + "西暦4桁+月2桁＋日2桁で入力してください");
				System.out.println("例：2021年8月1日---> 20210801");
				System.exit(-1);
			};
			
			//入力された文字列から，年月日を抽出する．
	 		s_year = str.substring(0,4);
			try{
				year = Integer.parseInt( s_year );
	 		} catch( NumberFormatException e ){
				System.out.println(nl + "不正な文字が使用されています．");
				System.exit( -1 );
			}
			
			try{
				month = Integer.parseInt( str.substring(4,6) );
	 		} catch( NumberFormatException e ){
				System.out.println(nl + "不正な文字が使用されています．");
				System.exit( -1 );
			}
			
			s_day = str.substring(6,8);
			System.out.println(s_day);
			try{
				day = Integer.parseInt( s_day );
	 		} catch( NumberFormatException e ){
				System.out.println(nl + "不正な文字が使用されています．");
				System.exit( -1 );
			}
			
			// *****************************************
			//  ② 変換処理を記述
			// 月のチェック
			if( month > 12 ||  month < 1 ){
				System.out.println(nl+month + "月は存在しません");
				System.exit(-1);
			}
			
			// 月ごとの最大値のチェック
			if ( day > month_max[month] ){
				System.out.println(nl + month + "月は" + month_max[month]+"日までです");
				System.exit(-1);
			}
			
			// 変換
			String output = new String( s_day + month_sh[month] + s_year );

			// 出力
			System.out.print(nl + year+ "年 " + month + "月 " + day + "日" );
			System.out.println( " -- > " + output );
			
		}
	}
}

