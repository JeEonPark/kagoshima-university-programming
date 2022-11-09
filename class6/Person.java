package class6;

public class Person {
    public String gender;
    public String name;
    public int age;
    public String birthday;

    public Person(String g, String n, int a, String b){
        gender = g;
        name = n;
        age = a;
        birthday = b;
    }

    public void showGender(){
        System.out.println("Gender : " + gender);
    }
    public void showName(){
        System.out.println("Name : " + name);
    }
    public void showAge(){
        System.out.println("Age : " + age);
    }
    public void showBirthday(){
        System.out.println("Birthday : " + birthday);
    }

    public void changeGender(String g){
        gender = g;
    }
    public void changeName(String n){
        name = n;
    }
    public void changeAge(int a){
        age = a;
    }
    public void changeBirthday(String b){
        birthday = b;
    }
}

