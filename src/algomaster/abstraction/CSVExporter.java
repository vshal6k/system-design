package algomaster.abstraction;

import java.util.List;

public class CSVExporter extends DataExporter{

    @Override
    public void export(List<String> data) {
        if(validate(data)){
            System.out.println("CSV: " + String.join(",", data));
        }
    }
    
}
