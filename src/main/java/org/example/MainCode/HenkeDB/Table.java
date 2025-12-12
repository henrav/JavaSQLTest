package org.example.MainCode.HenkeDB;

import java.nio.file.Path;

public class Table extends PathFindable{
    public Table(Path path){
        checkAvailability(path);
    }
    public Table(String path){
        checkAvailability(Path.of(path));
    }
    private void checkAvailability(Path path){

    }
}
