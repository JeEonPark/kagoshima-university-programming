package class6;

public class Person {
    public String sei;
    public String name;
    public int age;
    public String birthday;

    public Person() {
        
    }

    public Person(String s, String n, int a, String b){
        sei = s;
        name = n;
        age = a;
        birthday = b;
    }

    public void showSei(){
        System.out.println("Gender : " + sei);
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

    public void changeSei(String g){
        sei = g;
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

