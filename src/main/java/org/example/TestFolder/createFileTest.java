package org.example.TestFolder;

import org.example.MainCode.HenkeDB.DB;
import org.example.MainCode.HenkeDB.FileHandler;
import org.example.MainCode.HenkeDB.HenrikDBCore;
import org.example.annotations.AfterAll;
import org.example.annotations.BeforeAll;
import org.example.annotations.Order;
import org.example.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.example.Assert.*;
public class createFileTest {
    String dbName = "minDB";
    String newTablePath = "Data/mindata.sql";

    DB db;

    @BeforeAll
    public void init(){
        FileHandler.createDB(Path.of(dbName));
        this.db = new DB(dbName);
    }

    @Test
    @Order(value = 1)
    public void createDB() {
        db.createTable(newTablePath);
    }

    @Test
    @Order(value = 2)
    public void createTable()  {

    }

    @AfterAll
    public void removeStuff() throws IOException {
        FileHandler.deleteDB(Path.of(dbName));
    }
}
