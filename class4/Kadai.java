package class4;

import java.util.Scanner;

public class Kadai {
    int year;
    int month;
    int day;

    int[] d_end = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    String[] m = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    public Kadai() {
        this.year = 0;
        this.month = 0;
        this.day = 0;
    }

    public Kadai(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static void main(String[] args) {
        while(true){
            Scanner scanner = new Scanner(System.in);
            String num = scanner.nextLine();

            Kadai k = new Kadai();

            try {
                int scan_year = Integer.parseInt(num.substring(0, 4));
                int scan_month = Integer.parseInt(num.substring(4, 6));
                int scan_day = Integer.parseInt(num.substring(6, 8));

                k = new Kadai(scan_year, scan_month, scan_day);
            } catch (NumberFormatException e) {
                System.exit(-1);
            }

            if(k.month > 12 || k.month < 1) {
                System.exit(-1);
            } else if (k.day > k.d_end[k.month] || k.day < 1){
                System.exit(-1);
            } else {
                System.out.println(k.day + k.m[k.month] + k.year);
            }
            
            
        }
    }
}
