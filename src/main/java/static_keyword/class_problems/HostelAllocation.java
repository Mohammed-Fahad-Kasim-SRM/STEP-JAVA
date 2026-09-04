package static_keyword.class_problems;
import java.util.*;

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
        if (occupied < beds) {
            occupied++;
            System.out.println(name + " allotted to room " + roomNo);
        }
    }
}

public class HostelAllocation {

    static HostelRoom findAvailableRoom(HostelRoom[] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].occupied < rooms[i].beds)
                return rooms[i];
        }

        return null;
    }

    static void safeAllot(HostelRoom[] rooms, String studentName) {
        HostelRoom room = findAvailableRoom(rooms);

        if (room != null)
            room.allot(studentName);
        else
            System.out.println("No rooms available for " + studentName);
    }

    public static void main(String[] args) {
        HostelRoom[] rooms1 = {
                new HostelRoom("C-214", 3, 2),
                new HostelRoom("C-507", 2, 2)
        };

        safeAllot(rooms1, "Divya");

        HostelRoom[] rooms2 = {
                new HostelRoom("C-214", 3, 3),
                new HostelRoom("C-507", 2, 2)
        };

        safeAllot(rooms2, "Divya");
    }
}