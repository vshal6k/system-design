package algomaster.encapsulation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TemperatureSensor {
    private List<Double> readings = new ArrayList<>();

    public void addReading(double value) {
        if (value >= -50 && value <= 150) {
            readings.add(Double.valueOf(value));
        }
    }

    public double getAverage() {
        double average =  readings.stream().collect(Collectors.summarizingDouble(d -> Double.valueOf(d))).getAverage();
        return new BigDecimal(average).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public int getReadingCount() {
        return readings.size();
    }

    public List<Double> getReadings() {
        return new ArrayList<>(readings);
    }

    public static void main(String[] args) {
        TemperatureSensor sensor = new TemperatureSensor();
        System.out.println("Count: " + sensor.getReadingCount()); // 3
        System.out.println("Average: " + sensor.getAverage()); // 11.87
        sensor.addReading(22.5);
        sensor.addReading(23.1);
        sensor.addReading(200.0); // Should be rejected
        sensor.addReading(-10.0);

        System.out.println("Count: " + sensor.getReadingCount()); // 3
        System.out.println("Average: " + sensor.getAverage()); // 11.87
    }

}
