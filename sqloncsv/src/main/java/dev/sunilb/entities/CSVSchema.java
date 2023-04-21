package dev.sunilb.entities;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CSVSchema {
    private final CSVReader csvReader;
    private String [] fieldList;

    public CSVSchema(File file) throws FileNotFoundException {
        this.csvReader = new CSVReader(new FileReader(file));
    }

    public List<String> getFieldList() throws CsvValidationException, IOException {
        if(this.fieldList == null) this.fieldList = this.csvReader.readNext();
        return Arrays.asList(this.fieldList);
    }
}
