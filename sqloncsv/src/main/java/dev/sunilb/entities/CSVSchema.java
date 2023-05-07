package dev.sunilb.entities;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVSchema {
    private String schemaName;
    private List<String> columns;

    public List<Raw> getRaws() {
        return raws;
    }

    private List<Raw> raws;

    private int rows=0;
    public int getRows(){
        return rows;
    }
//    boolean allValuesRequired=true;
//    column name and values of it
//    we can map for faster search on columns
//    public Map<String, List<Raw>> getData() {
//        return data;
//    }
//    private Map<String, List<Raw>> data;
//    public void setData(Map<Integer, List<Raw>> data) {
//        this.data = data;
//    }
    private String [] fieldList;

    public CSVSchema(String schemaName,File file) throws IOException, CsvValidationException {
        this.schemaName=schemaName;
        this.raws = new ArrayList<>();
        CSVReader csvReader= new CSVReader(new FileReader(file));
        this.fieldList=csvReader.readNext();
        insertRaws(csvReader);
    }


    public List<String> getFieldList() throws CsvValidationException, IOException {
        return List.of(fieldList);
    }

    public int insertRaws(CSVReader csvReader) throws IOException, CsvValidationException {
        int rawId=0;
        String[] values;
        while ((values=csvReader.readNext())!=null){
            try {
                insertRaw(rawId,values);
                rawId++;
            }catch (Exception e){

            }
        }
        this.rows=rawId;
        System.out.println(rawId+" no of rows added");
        return rawId;
    }

    private void insertRaw(int rawId,String[] values){
        Raw raw=new Raw(rawId,values);
        this.raws.add(raw);
    }
}
