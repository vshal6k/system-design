package algomaster.abstraction;

import java.util.List;

public abstract class DataExporter {

    public boolean validate(List<String> data){
        if(data != null && !data.isEmpty()){
            System.out.println("Data is Valid");
            return true;
        } 
        else{
            System.out.println("Data is invalid");
            return false;
        } 
    }

    public abstract void export(List<String> data);
}
