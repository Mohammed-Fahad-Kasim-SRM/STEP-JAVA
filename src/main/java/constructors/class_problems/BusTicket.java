package constructors.class_problems;
import java.util.ArrayList;

public class BusTicket {
    private String passengerName;
    private String destination;
    private boolean checkedIn;

    public BusTicket(String passengerName, String destination) {
        if (passengerName == null || passengerName.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (!passengerName.matches("[a-zA-Z ]+")) {
            throw new IllegalArgumentException();
        }

        if (destination == null || destination.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.passengerName = passengerName;
        this.destination = destination;
        this.checkedIn = false;
    }

    void markCheckedIn() {
        if (checkedIn) {
            throw new IllegalStateException();
        }

        checkedIn = true;
    }

    static void processBatch(String[][] rawBookings) {
        ArrayList<String> accepted = new ArrayList<>();

        int valid = 0;
        int rejected = 0;
        int duplicates = 0;

        for (String[] booking : rawBookings) {
            try {
                BusTicket ticket = new BusTicket(booking[0], booking[1]);

                String key = ticket.passengerName.toLowerCase() + "|" +
                        ticket.destination.toLowerCase();

                if (accepted.contains(key)) {
                    duplicates++;
                } else {
                    accepted.add(key);
                    valid++;
                }

            } catch (Exception e) {
                rejected++;
            }
        }

        System.out.println("Valid: " + valid);
        System.out.println("Rejected: " + rejected);
        System.out.println("Duplicates skipped: " + duplicates);
    }

    public static void main(String[] args) {
        String[][] bookings = {
                {"Divya", "Chennai"},
                {"", "Bangalore"},
                {"Ravi123", "Pune"},
                {"Divya", "Chennai"},
                {" ", " "}
        };

        processBatch(bookings);

        BusTicket ticket = new BusTicket("Ravi", "Pune");

        ticket.markCheckedIn();

        try {
            ticket.markCheckedIn();
        } catch (Exception e) {
            System.out.println("Already checked in");
        }
    }
}