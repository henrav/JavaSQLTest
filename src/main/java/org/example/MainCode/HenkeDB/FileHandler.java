package org.example.MainCode.HenkeDB;

import org.example.MainCode.DBException;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Comparator;


public class FileHandler{

    private static final Path BASE_DIR = Paths.get("src", "main", "java", "org", "example", "MainCode");
    private static final Path DB_DIR = Paths.get("src", "main", "java", "org", "example", "MainCode", "DB");
    private static final Path SETTINGS_DIR = Paths.get("src", "main", "java", "org", "example", "MainCode", "SETTINGS", "Config.properties");




    public static void createDB(Path path) {
        if (path.getNameCount() > 1){
            throw new DBException("Invalid DB Name");
        }
        Path newPath = DB_DIR.resolve(path);
        try{
            Files.createDirectory(newPath);
            // src/main/java/org/example/MainCode/DB/minDB
            //        // src/main/java/org/example/MainCode/DB/minDB
        }catch (IOException e){
            throw new DBException("Unable to create Directory '" + newPath +"' ", e);
        }

        try{
            Files.createFile(newPath.resolve(path));
        }catch (IOException e){
            throw new DBException("unable to create file '" + newPath + "': " + e.getClass(), e);
        }
    }



    public static Boolean findDB(Path path) {
        Path newPath = DB_DIR.resolve(path);
        return Files.isDirectory(newPath);
    }

    public static boolean tableExists(Path tableName, Path dbName){
       Path newTableName = tableName.getName(tableName.getNameCount()- 1);
       Path newPath = DB_DIR.resolve(dbName.resolve(newTableName));
       if (Files.exists(newPath)) throw new DBException("table already exists '" + newTableName + "' for db '" + dbName);
       return true;
    }

    public static void createTableSrcPath(Path tablePath, Path dbName) {
        String fileType = String.valueOf(tablePath.getFileName());
        if (!fileType.endsWith("sql")) throw new DBException("not an sql file");
        Path tableName = tablePath.getFileName();
        try{
            Files.createFile(DB_DIR.resolve(dbName.resolve(tableName)));
        }catch (IOException e){
            throw new DBException("error creating table '" + tableName + "': ", e);
        }
    }

    public static boolean findFile(Path of) {
        return Files.exists(of);
    }

    public static Path getDB(Path path) {
        Path newPath = DB_DIR.resolve(path);
        if (Files.isDirectory(newPath)) return path;
        else throw new DBException("No such db exists '" + path + "': ");
    }



    public static void deleteDB(Path dbName) {
        Path dbPath = DB_DIR.resolve(dbName);

        if (!Files.exists(dbPath)) {
            throw new DBException("No such db exists '" + dbName + "'");
        }
        if (!Files.isDirectory(dbPath)) {
            throw new DBException("Path is not a directory for db '" + dbName + "': " + dbPath);
        }
        try {
            Files.walk(dbPath)
                    .sorted(Comparator.reverseOrder())
                    .forEach(p -> {
                        try {
                            Files.delete(p);
                        } catch (IOException e) {
                            throw new DBException("Failed to delete '" + p + "' while deleting db '" + dbName + "'", e);
                        }
                    });
        } catch (IOException e) {
            throw new DBException("Error walking db directory '" + dbPath + "' for deletion", e);
        }
    }

    public static void deleteTable(Path tableName, Path dbName) {
        Path simpleName = tableName.getFileName();
        if (simpleName == null) {
            throw new DBException("Invalid table name: '" + tableName + "'");
        }

        Path tablePath = DB_DIR.resolve(dbName).resolve(simpleName);

        try {
            if (!Files.deleteIfExists(tablePath)) {
                throw new DBException("No such table '" + simpleName + "' for db '" + dbName + "': " + tablePath);
            }
        } catch (IOException e) {
            throw new DBException("Failed to delete table '" + simpleName + "' for db '" + dbName + "': " + tablePath, e);
        }
    }

}


