package org.example.MainCode.HenkeDB;

import org.example.MainCode.SQLIntepreter.DataTypes.DataType;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvTableStream implements AutoCloseable {
    private String tableName;
    private BufferedReader reader;
    private List<String> columns;
    private List<String> dataTypes;
    public CsvTableStream(String tableName, Path path) throws IOException {
        this.tableName = tableName;
        this.reader = Files.newBufferedReader(path);
        String header = reader.readLine();
        if (header == null) throw new RuntimeException("empty file" + path);
        columns = splitCsvLine(header);
        setHeader();
    }

    private void setHeader() throws IOException {
        String datatype = reader.readLine();
        if (datatype == null) throw new RuntimeException("missing datatype declarations line");
        List<String> datatypescsv = splitCsvLine(datatype);
        if (datatypescsv.size() != columns.size()) throw new RuntimeException("missmatch between header and datatypes declaration");
        this.dataTypes = datatypescsv;
    }

    public Map<String, DataType<?>> nextRow() throws IOException {
        String line;
        while ((line = reader.readLine()) != null){
            line = line.trim();
            if (line.isEmpty()) continue;
            List<String> data = splitCsvLine(line);
            if (data.size() != columns.size()) throw new RuntimeException("bad line");
            Map<String, DataType<?>> out = new HashMap<>();
            for (int i = 0; i < data.size(); i++){
                out.put(columns.get(i), stringToType(dataTypes.get(i), data.get(i)));
            }
            return out;
        }
        return null;
    }


    private DataType<?> stringToType(String s, String  val) {
        if (val == null || val.isBlank()) return new DataType.NULL();

        return switch (s.toLowerCase()) {
            case "string" -> new DataType.STRING(val);
            case "int" -> new DataType.INT(Integer.parseInt(val));
            case "float" -> new DataType.FLOAT(Float.parseFloat(val));
            case "boolean" -> new DataType.BOOLEAN(Boolean.parseBoolean(val));
            default -> throw new IllegalArgumentException("Unsupported data type: " + s);
        };
    }

    private List<String> splitCsvLine(String line) {
        String[] lines = line.split(",", -1);
        List<String> out = new ArrayList<>(lines.length);
        for (String p : lines) out.add(p.trim());
        return out;
    }


    @Override
    public void close() throws Exception {
        reader.close();
    }
}
