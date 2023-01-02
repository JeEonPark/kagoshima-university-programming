package class8;

import java.util.Scanner;

public class StudentList {
    public static void main(String[] args) {
        Student[] studentList = new Student[10];

        for(int i = 0; i < 3; i++) {
            while(true) {
                Scanner scan = new Scanner(System.in);

                String sei = scan.next();
                String name = scan.next();
                int age = Integer.parseInt(scan.next());
                String birthday = scan.next();
                String studentid = scan.next();
                int studentyear = Integer.parseInt(scan.next());
                String gakubu = scan.next();
                String gakka = scan.next();

                if(studentid.length() == 10 && birthday.length() == 8) {
                    studentList[i] = new Student(sei, name, age, birthday, studentid, studentyear, gakubu, gakka);
                    break;
                } else {
                    System.out.println("Please enter again.");
                }

            }
        } 

        for(int i = 0; i<3; i++) {
            System.out.println("Sei: " + studentList[i].getSei()
                                + " | Name: "+ studentList[i].getName()
                                + " | Age: " + studentList[i].getAge()
                                + " | Birthday: " + studentList[i].getBirthday()
                                + " | ID:" + studentList[i].getStudentid()
                                + " | Year:" + studentList[i].getStudentyear()
                                + " | Gakubu:" + studentList[i].getGakubu()
                                + " | Gakka:" + studentList[i].getGakka());        
        }
    }
}
