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

class ScholarshipFeeAccount extends FeeAccount {
    private double scholarshipPercent;

    ScholarshipFeeAccount(String regNo, double totalFee,
                          double amountPaid, double scholarshipPercent) {
        super(regNo, totalFee, amountPaid);
        this.scholarshipPercent = scholarshipPercent;
    }

    double effectiveDue() {
        return getDue() - (getDue() * scholarshipPercent / 100);
    }
}

public class FeeSystem {

    public static void main(String[] args) {
        FeeAccount plain = new FeeAccount("RA01", 150000, 0);
        HostelFeeAccount hostel = new HostelFeeAccount("RA02", 200000, 60000);
        ScholarshipFeeAccount scholarship =
                new ScholarshipFeeAccount("RA03", 180000, 0, 20);

        plain.pay(150000);

        if (plain instanceof HostelFeeAccount) {
            ((HostelFeeAccount) plain).payInTwoInstallments(10000);
        }

        if (hostel instanceof HostelFeeAccount) {
            ((HostelFeeAccount) hostel).payInTwoInstallments(0);
        }

        if (scholarship instanceof ScholarshipFeeAccount) {
            System.out.println("Scholarship account effective due: Rs " +
                    ((ScholarshipFeeAccount) scholarship).effectiveDue());
        }

        System.out.println("Plain account due: Rs " + plain.getDue());
        System.out.println("Hostel account due: Rs " + hostel.getDue());
    }
}