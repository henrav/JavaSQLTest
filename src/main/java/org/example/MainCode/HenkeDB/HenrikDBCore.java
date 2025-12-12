package org.example.MainCode.HenkeDB;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

public class HenrikDBCore {
    DB db;
    Config config;
    public HenrikDBCore(){
    };
    public DB getDb(){
        return db;
    }

    private void createDB(Path path) throws IOException {
        if (path.getNameCount() > 1){
            throw new RuntimeException("Wrong path");
        }
    }

    public void createDB(String path) throws IOException {
        createDB(Path.of(path));
    }

    private void createTable(Path dbPath, Path tablePath){

    }

    public void createTable(String dbName, String tableName){
       createTable(Path.of(dbName), Path.of(tableName));
    }

}
