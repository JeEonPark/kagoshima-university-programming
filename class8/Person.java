package class8;

public class Person {
    private String sei;
    private String name;
    private int age;
    private String birthday;

    public Person() {
        
    }

    public Person(String sei, String name, int age, String birthday){
        this.sei = sei;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
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

    public String getSei(){
        return sei;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getBirthday(){
        return birthday;
    }

    public void setSei(String sei){
        this.sei = sei;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setBirthday(String birthday){
        this.birthday = birthday;
    }
}

