package class4;

import java.lang.*;

public class DateClass {
    // フィールド
    int year;
    int month;
    int day;

    // メソッド
    public DateClass() {
        this.year = 2000;
        this.month = 1;
        this.day = 1;
    }

    public DateClass(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void print() {
        System.out.println(year + "年 " + month + "月 " + day + "日");
    }

}
