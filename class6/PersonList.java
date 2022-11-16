package class6;

public class PersonList {
    public static void main(String[] args) {
        Person[] personList = new Person[100];

        personList[0] = new Person("Male", "JEEONPARK", 22, "1999/11/29");
        personList[0].showSei();
        personList[0].showName();
        personList[0].showAge();
        personList[0].showBirthday();
        System.out.println("\n");

        personList[0].changeSei("Female");
        personList[0].changeName("ChangePARK");
        personList[0].changeAge(12);
        personList[0].changeBirthday("2000/01/01");
        personList[0].showSei();
        personList[0].showName();
        personList[0].showAge();
        personList[0].showBirthday();
    }
}

