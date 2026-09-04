package static_keyword.assigment_problems;
import java.util.*;

class Employee {
    private String empId;
    private String empName;
    private double salary;

    Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    double getSalary() {
        return salary;
    }
}

class ManagerEmployee extends Employee {
    private double teamBonus;

    ManagerEmployee(String empId, String empName, double salary,
                    double teamBonus) {
        super(empId, empName, salary);
        this.teamBonus = teamBonus;
    }

    double effectiveSalary() {
        return getSalary() + teamBonus;
    }
}

class ParkingSlot {
    String slotNo;
    int capacity;
    int occupiedCount;

    ParkingSlot(String slotNo, int capacity, int occupiedCount) {
        this.slotNo = slotNo;
        this.capacity = capacity;
        this.occupiedCount = occupiedCount;
    }

    void allot(String vehicleNo) {
        if (occupiedCount < capacity)
            occupiedCount++;
    }
}

class CompanyEmployeeRecord {
    String name;
    String empId;
    Employee employee;
    ParkingSlot slot;

    static int totalRecords = 0;

    CompanyEmployeeRecord(String name, String empId,
                          Employee employee) {
        this.name = name;
        this.empId = empId;
        this.employee = employee;
        this.slot = null;
        totalRecords++;
    }

    String fullProfile() {
        double pay;

        if (employee instanceof ManagerEmployee)
            pay = ((ManagerEmployee) employee).effectiveSalary();
        else
            pay = employee.getSalary();

        String slotNumber;

        if (slot == null)
            slotNumber = "no parking assigned";
        else
            slotNumber = slot.slotNo;

        return name + " | Pay: Rs " + pay +
                " | Slot: " + slotNumber;
    }
}

public class HRParkingSystem {

    static ParkingSlot findAvailableSlot(ParkingSlot[] slots) {
        for (int i = 0; i < slots.length; i++) {
            if (slots[i].occupiedCount < slots[i].capacity)
                return slots[i];
        }

        return null;
    }

    static void safeAllot(CompanyEmployeeRecord record,
                          ParkingSlot[] slots) {
        ParkingSlot slot = findAvailableSlot(slots);

        if (slot != null) {
            slot.allot(record.empId);
            record.slot = slot;
        }
    }

    public static void main(String[] args) {

        ParkingSlot[] slots = {
                new ParkingSlot("A1", 1, 0),
                new ParkingSlot("A2", 1, 0)
        };

        CompanyEmployeeRecord divya =
                new CompanyEmployeeRecord(
                        "Divya",
                        "E101",
                        new ManagerEmployee(
                                "E101", "Divya", 70000, 8000));

        CompanyEmployeeRecord karan =
                new CompanyEmployeeRecord(
                        "Karan",
                        "E102",
                        new Employee(
                                "E102", "Karan", 40000));

        CompanyEmployeeRecord meera =
                new CompanyEmployeeRecord(
                        "Meera",
                        "E103",
                        new Employee(
                                "E103", "Meera", 12000));

        safeAllot(divya, slots);
        safeAllot(karan, slots);

        System.out.println(divya.fullProfile());
        System.out.println(karan.fullProfile());
        System.out.println(meera.fullProfile());

        System.out.println("Total records: " +
                CompanyEmployeeRecord.totalRecords);
    }
}