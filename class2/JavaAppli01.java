import java.lang.*;

public class JavaAppli01 {
    int a = 1;
    int b = 2;

    public JavaAppli01() {
        System.out.println("Javaアプリケーション人門");
    }

    public void add() {
        int c = a + b;
        String str = Integer.valueOf(c).toString();
        System.out.println("a + b = " + str);
    }

    public void minus() {
        int c = a - b;
        String str = Integer.valueOf(c).toString();
        System.out.println("a - b = " + str);
    }

    public void multiple(double x, double y, double z) {
        double answer = x * y * z;
        System.out.println("x * y * z = " + answer);
    }

    public static void main(String[] args) {
        JavaAppli01 appli = new JavaAppli01();
        appli.add();
        appli.minus();
        appli.multiple(1.5, 123, 3.14);
    }
}