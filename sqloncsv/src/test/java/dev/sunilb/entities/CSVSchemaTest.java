package dev.sunilb.entities;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CSVSchemaTest {

    @Test
    public void shouldReturnFieldsListForCSVFile() {

        String fileName = "csv/basic.csv";

        //TODO: May have to extract this to a utils package for testing as this looks like a common method
        File file = loadResourceFile(fileName);

        //TODO: now that the basic code is stitched together, now load the real file and extract real fields
        CSVSchema schema = new CSVSchema(file);
        List<String> fieldList = schema.getFieldList();
        List<String> expectedList = List.of("A", "B", "C");
        Assert.assertEquals(fieldList, expectedList);
    }

    private File loadResourceFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        return file;
    }
}
