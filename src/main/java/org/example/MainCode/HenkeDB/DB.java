package org.example.MainCode.HenkeDB;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

public class DB extends PathFindable {

    public DB(){
    }
    public DB(String path){
        init(path);
    }

    private void init(String name){
        this.path = FileHandler.getDB(Path.of(name));
    }

    public void createTable(String srcFilePath)  {
        FileHandler.createTableSrcPath(Path.of(srcFilePath), path);

    }

}
