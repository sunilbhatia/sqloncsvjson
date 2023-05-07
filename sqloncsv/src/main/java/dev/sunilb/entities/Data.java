package dev.sunilb.entities;

import java.util.HashMap;
import java.util.Map;

public class Data {
    private String dataBaseName;
    private Map<String,CSVSchema> data=new HashMap<>();
    public CSVSchema getData(String schemaName){
        return data.get(schemaName);
    }
    public void setData(String schemaName,CSVSchema csvSchema){
        data.put(schemaName,csvSchema);
    }
}
