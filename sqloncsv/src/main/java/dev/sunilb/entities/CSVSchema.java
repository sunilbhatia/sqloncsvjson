package dev.sunilb.entities;

import java.io.File;
import java.util.List;

public class CSVSchema {
    private final File csvFile;

    public CSVSchema(File file) {
        this.csvFile = file;
    }

    public List<String> getFieldList() {
        return List.of("A", "B", "C");
    }
}
