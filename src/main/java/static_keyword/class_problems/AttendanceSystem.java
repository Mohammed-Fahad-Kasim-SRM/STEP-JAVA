package static_keyword.class_problems;
import java.util.*;

class SrmStudent {
    String name;
    String regNo;
    int attendance;

    SrmStudent(String name, String regNo, int attendance) {
        this.name = name;
        this.regNo = regNo;
        this.attendance = attendance;
    }

    void addAttendanceUpdate(int newAttendance) {
        attendance = newAttendance;
    }

    boolean isEligible() {
        return attendance >= 75;
    }

    static double classAverage(SrmStudent[] students) {
        int total = 0;

        for (int i = 0; i < students.length; i++) {
            total += students[i].attendance;
        }

        return (double) total / students.length;
    }
}

public class AttendanceSystem {

    public static void main(String[] args) {
        SrmStudent[] students = new SrmStudent[5];

        students[0] = new SrmStudent("Ravi", "RA231100301011", 82);
        students[1] = new SrmStudent("Anitha", "RA231100301012", 68);
        students[2] = new SrmStudent("Karthik", "RA231100301013", 91);
        students[3] = new SrmStudent("Meera", "RA231100301014", 74);
        students[4] = new SrmStudent("Suresh", "RA231100301015", 60);

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].name + " - " +
                    students[i].attendance + "% - " +
                    (students[i].isEligible() ? "Eligible" : "Detained"));
        }

        System.out.println("Class average: " +
                SrmStudent.classAverage(students) + "%");
    }
}