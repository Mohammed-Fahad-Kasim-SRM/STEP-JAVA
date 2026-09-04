package static_keyword.class_problems;
import java.util.*;

class BrokenStudent {
    static String name;
    static String regNo;
    static int attendance;

    BrokenStudent(String name, String regNo, int attendance) {
        BrokenStudent.name = name;
        BrokenStudent.regNo = regNo;
        BrokenStudent.attendance = attendance;
    }
}

class SrmStudent {
    String name;
    String regNo;
    int attendance;

    static String university = "SRM";
    static int admissionCount = 0;

    SrmStudent(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;

        admissionCount++;
        this.regNo = "RA2311003010" + (10 + admissionCount);
    }

    void printIdCard() {
        System.out.println(name + " | " + regNo);
    }

    static void printTotalAdmissions() {
        System.out.println("Students admitted so far: " + admissionCount);
    }
}

public class StudentStaticDemo {

    public static void main(String[] args) {

        BrokenStudent s1 = new BrokenStudent("Ravi", "RA01", 82);
        BrokenStudent s2 = new BrokenStudent("Meera", "RA02", 74);

        System.out.println("Broken version:");
        System.out.println(s1.name);
        System.out.println(s2.name);

        SrmStudent admission1 = new SrmStudent("Ravi", 82);
        SrmStudent admission2 = new SrmStudent("Meera", 74);

        System.out.println("\nFixed version:");
        admission1.printIdCard();
        admission2.printIdCard();

        SrmStudent.printTotalAdmissions();
    }
}