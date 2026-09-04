package static_keyword.class_problems;
import java.util.*;

class FeeAccount {
    private String regNo;
    private double totalFee;
    private double amountPaid;

    FeeAccount(String regNo, double totalFee, double amountPaid) {
        this.regNo = regNo;
        this.totalFee = totalFee;
        this.amountPaid = amountPaid;
    }

    void pay(double amount) {
        if (amount > 0)
            amountPaid += amount;
        else
            System.out.println("Payment rejected");
    }

    double getDue() {
        return totalFee - amountPaid;
    }
}

class HostelFeeAccount extends FeeAccount {

    HostelFeeAccount(String regNo, double totalFee, double amountPaid) {
        super(regNo, totalFee, amountPaid);
    }

    void payInTwoInstallments(double amount) {
        if (amount > 0) {
            pay(amount / 2);
            pay(amount / 2);
        }
    }
}

class HostelRoom {
    String roomNo;
    int beds;
    int occupied;

    HostelRoom(String roomNo, int beds, int occupied) {
        this.roomNo = roomNo;
        this.beds = beds;
        this.occupied = occupied;
    }

    void allot(String name) {
        if (occupied < beds)
            occupied++;
    }
}

class SrmStudent {
    String name;
    String regNo;
    HostelFeeAccount feeAccount;
    HostelRoom room;

    static int totalStudents = 0;

    SrmStudent(String name, String regNo,
               HostelFeeAccount feeAccount) {
        this.name = name;
        this.regNo = regNo;
        this.feeAccount = feeAccount;
        this.room = null;
        totalStudents++;
    }

    String fullStatus() {
        String roomNumber;

        if (room == null)
            roomNumber = "unallotted";
        else
            roomNumber = room.roomNo;

        return name + " | Due: Rs " +
                feeAccount.getDue() +
                " | Room: " + roomNumber;
    }
}

public class CollegeManagementSystem {

    static HostelRoom findAvailableRoom(HostelRoom[] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].occupied < rooms[i].beds)
                return rooms[i];
        }

        return null;
    }

    static void safeAllot(SrmStudent student, HostelRoom[] rooms) {
        HostelRoom room = findAvailableRoom(rooms);

        if (room != null) {
            room.allot(student.name);
            student.room = room;
        } else {
            System.out.println("No rooms available for " + student.name);
        }
    }

    public static void main(String[] args) {

        HostelRoom[] rooms = {
                new HostelRoom("C-214", 1, 0),
                new HostelRoom("C-507", 1, 0)
        };

        SrmStudent ravi = new SrmStudent(
                "Ravi",
                "RA231100301011",
                new HostelFeeAccount("RA231100301011", 150000, 10000)
        );

        SrmStudent anitha = new SrmStudent(
                "Anitha",
                "RA231100301012",
                new HostelFeeAccount("RA231100301012", 200000, 20000)
        );

        SrmStudent karthik = new SrmStudent(
                "Karthik",
                "RA231100301013",
                new HostelFeeAccount("RA231100301013", 200000, 0)
        );

        safeAllot(ravi, rooms);
        safeAllot(anitha, rooms);

        ravi.feeAccount.pay(0);
        anitha.feeAccount.pay(-5000);
        karthik.feeAccount.pay(5000);

        System.out.println(ravi.fullStatus());
        System.out.println(anitha.fullStatus());
        System.out.println(karthik.fullStatus());

        System.out.println("Total students: " + SrmStudent.totalStudents);
    }
}