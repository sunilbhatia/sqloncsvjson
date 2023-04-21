package dev.sunilb.entities;

import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static dev.sunilb.utils.Utils.loadResourceFile;

public class CSVSchemaTest {

    @Test
    public void shouldReturnFieldsListForCSVFile() throws IOException, CsvValidationException {

        String fileName = "csv/basic.csv";

        File file = loadResourceFile(fileName);

        CSVSchema schema = new CSVSchema(file);
        List<String> fieldList = schema.getFieldList();
        List<String> expectedList = List.of("col1", "col2", "col3");
        Assert.assertEquals(fieldList, expectedList);
    }

}
