package Math;

public class Physics {

    /**
     *
     * @param time1 -> in milliseconds
     * @param time2 -> in milliseconds
     * @param target -> in seconds
     * @return returns the time the program should wait to get a estimated target frame per second
     */
    public static double deltaTime(double time1, double time2, double target) {
        double difference = time2 - time1;
        return difference / target;
    }

    public static double convertUnits(double value, double conversionFactor) {
        return value * conversionFactor;
    }

}
