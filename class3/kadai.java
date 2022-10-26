import java.util.Scanner;

public class kadai {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;

        while (true) {
            System.out.print("A?   ");
            Scanner s1 = new Scanner(System.in);
            String str1 = s1.nextLine();

            System.out.print("B?   ");
            Scanner s2 = new Scanner(System.in);
            String str2 = s2.nextLine();

            try {
                a = Integer.parseInt(str1);
                b = Integer.parseInt(str2);
            } catch (NumberFormatException e) {
                System.out.println("プログラムを終了します");
                System.exit(-1);
            }

            if (a > b) {
                System.out.println("１番目の数値の方が大きいです");
            } else {
                System.out.println("２番目の数値の方が大きいです");
            }
        }
    }
}
