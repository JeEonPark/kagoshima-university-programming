package class7;

public class StudentList {
    public static void main(String[] args) {
        Student[] studentList = new Student[10];

        studentList[0] = new Student("Park", "Jeeon", 22, "19991129", 1234, 2018, "A-gaku", "A-gakka");
        studentList[1] = new Student("Cho", "Yerim", 23, "19990324", 2345, 2018, "B-gaku", "B-gakka");
        studentList[2] = new Student("C", "ccc", 22, "20001111", 1234, 2018, "C-gaku", "C-gakka");
        studentList[3] = new Student("D", "ddd", 22, "20001112", 1234, 2018, "D-gaku", "D-gakka");
        studentList[4] = new Student("E", "eee", 22, "20001113", 1234, 2018, "E-gaku", "E-gakka");
        studentList[5] = new Student("F", "fff", 22, "20001114", 1234, 2018, "F-gaku", "F-gakka");
        studentList[6] = new Student("G", "ggg", 22, "20001115", 1234, 2018, "G-gaku", "G-gakka");
        studentList[7] = new Student("H", "hhh", 22, "20001116", 1234, 2018, "H-gaku", "H-gakka");
        studentList[8] = new Student("I", "iii", 22, "20001117", 1234, 2018, "I-gaku", "I-gakka");
        studentList[9] = new Student("J", "jjj", 22, "20001118", 1234, 2018, "J-gaku", "J-gakka");

        for(int i = 0; i<10; i++) {
            studentList[i].showSei();
            studentList[i].showName();
            studentList[i].showAge();
            studentList[i].showBirthday();
            studentList[i].showStudentid();
            studentList[i].showStudentyear();
            studentList[i].showGakubu();
            studentList[i].showGakka();
            
        }
    }
}
