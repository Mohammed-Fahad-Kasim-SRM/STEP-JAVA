package constructors.class_problems;
public class FareSplitter {
    private String tripId;
    private double totalFare;
    private int passengerCount;

    public FareSplitter(String tripId, double totalFare, int passengerCount) {
        if (totalFare < 0 || passengerCount <= 0) {
            throw new IllegalArgumentException();
        }

        this.tripId = tripId;
        this.totalFare = totalFare;
        this.passengerCount = passengerCount;
    }

    public FareSplitter(String tripId, double totalFare) {
        this(tripId, totalFare, 2);
    }

    public FareSplitter(String tripId) {
        this(tripId, 0, 2);
    }

    double[] fareBreakdown() {
        double[] result = new double[passengerCount];

        long totalCents = Math.round(totalFare * 100);
        long share = totalCents / passengerCount;
        long remainder = totalCents % passengerCount;

        for (int i = 0; i < passengerCount; i++) {
            result[i] = share / 100.0;
        }

        result[passengerCount - 1] += remainder / 100.0;

        return result;
    }

    boolean isConfirmationOverdue(int confirmed, int expected) {
        return confirmed < expected;
    }

    public static void main(String[] args) {
        FareSplitter f1 = new FareSplitter("TRIP001", 100000, 3);

        double[] result = f1.fareBreakdown();

        for (double value : result) {
            System.out.printf("%.2f ", value);
        }

        System.out.println();

        FareSplitter f2 = new FareSplitter("TRIP003");

        double[] result2 = f2.fareBreakdown();

        for (double value : result2) {
            System.out.printf("%.2f ", value);
        }

        System.out.println();

        System.out.println(f1.isConfirmationOverdue(2, 3));
    }
}