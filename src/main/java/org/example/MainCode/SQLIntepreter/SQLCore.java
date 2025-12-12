package org.example.MainCode.SQLIntepreter;

import org.example.MainCode.SQLIntepreter.Statements.Statement;

public class SQLCore {


    public static void handle(String string){
        String newString = string.strip();
        String word ="";
        for (int i = 0; i < newString.length(); i++){
            char c = newString.charAt(i);
            if (c == ' ')break;
            word += c;
        }
        Statement statement = dispatchStatement(word, newString);
    }

    private static Statement dispatchStatement(String word, String newString){
        if (word.equalsIgnoreCase("select")) {
            return handleSelectStatement(newString);
        }if (word.equalsIgnoreCase("insert")){
            handleInsertStatement();
        }
        return null;
    }

    public static Statement handleSelectStatement(String newString){

    return null;
    }

    public static void handleInsertStatement(){
        System.out.println("Insert");
    }


}
