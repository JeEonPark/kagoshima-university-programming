import java.lang.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kadai {
    public static void main(String[] args) {
        String rx = "(0)(\\d{1,4})-(\\d{1,4})-(\\d{4})";

        Pattern rx_pattern = Pattern.compile(rx);

        String nl = System.lineSeparator();

        while(true) {
            System.out.println(nl + "電話番号を市外局番から入力してください：");
            Scanner s = new Scanner(System.in);
            String str = s.nextLine();

            boolean m = Pattern.matches(rx, str);
            if(!m) {
                System.out.println(nl + "電話版後ではありません");
                continue;
            } else {
                System.out.println(nl + "電話番号を確認しました");
                System.exit(-1);
            }

            // Matcher matcher = rx_pattern.matcher(str);
            // String[] cap = new String[5];

            // if(matcher.find()) {
            //     for(int i = 0; i < 5; i++) {
            //         cap[i] = String.valueOf(matcher.group(i));
            //     }
            //     for(int i = 0; i < 5; i++) {
            //         System.out.println(nl + "Group " + i + " : " + cap[i]);
            //     }
            // }
        }
    }
}