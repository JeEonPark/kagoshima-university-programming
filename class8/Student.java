package class7;

public class Student extends Person {

    private int studentid;
    private int studentyear;
    private String gakubu;
    private String gakka;

    public Student(String sei, String name, int age, String birthday, int studentid, int studentyear, String gakubu, String gakka) {
        super(sei, name, age, birthday);
        this.studentid = studentid;
        this.studentyear = studentyear;
        this.gakubu = gakubu;
        this.gakka = gakka;
    }

    public void showStudentid() {
        System.out.println("Student ID : " + studentid);
    }
    public void showStudentyear() {
        System.out.println("Student Year : " + studentyear);
    }
    public void showGakubu() {
        System.out.println("Gakubu : " + gakubu);
    }
    public void showGakka() {
        System.out.println("Gakka : " + gakka);
    }

    public int getStudentid() {
        return this.studentid;
    }
    public int getStudentyear() {
        return this.studentyear;
    }
    public String getGakubu() {
        return this.gakubu;
    }
    public String getGakka() {
        return this.gakka;
    }
    
    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }
    public void setStudentyear(int studentyear) {
        this.studentyear = studentyear;
    }
    public void setGakubu(String gakubu) {
        this.gakubu = gakubu;
    }
    public void setGakka(String gakka) {
        this.gakka = gakka;
    }
    
}
