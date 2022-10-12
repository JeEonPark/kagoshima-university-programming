import java.lang.*;

public class JavaAppli02 {
    double a = 3.141592;
    int b = 2;

    public void solutionOne() {
        double answer = a + b;
        System.out.println(answer + " / " + ((Object)answer).getClass().getName());
    }

    public void solutionTwo() {
        int answer = (int) a + b;
        System.out.println(answer + " / " + ((Object)answer).getClass().getName());
    }

    public static void main(String[] args) {
        JavaAppli02 appli = new JavaAppli02();
        appli.solutionOne();
        appli.solutionTwo();
    }
}
