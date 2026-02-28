package algomaster.abstraction;

import java.util.List;

public class JSONExporter extends DataExporter{

    @Override
    public void export(List<String> data) {
        if(validate(data)){
            System.out.println("JSON: " + data.toString());
        }
    }
    
}
