package org.example.MainCode.InMemoryDB;

import org.example.MainCode.SQLIntepreter.DataTypes.DataType;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Table {
    public  String name;

    private List<String> columns;

    private List<Map<String, DataType>> rows;


    public Table(String name, List<String> columns, List<Map<String, DataType>> rows) {
        this.name = name;
        this.columns = columns;
        this.rows = rows;
    }

    public static Table loadCsv(String tableName, Path path) throws IOException {


    }
}
