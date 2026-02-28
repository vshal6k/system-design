package algomaster.abstraction;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Shape shape;
        // shape = new Circle("Big Circle", 10);
        // shape.area();
        // shape.perimeter();
        // shape.describe();

        // shape = new Rectangle("Small Rectangle", 2, 3);
        // shape.area();
        // shape.perimeter();
        // shape.describe();

        DataExporter csv = new CSVExporter();
        csv.export(List.of("Alice", "Bob", "Charlie"));

        DataExporter json = new JSONExporter();
        json.export(List.of("Alice", "Bob", "Charlie"));

        csv.export(List.of()); // Should fail validation

    }
}
