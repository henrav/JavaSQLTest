package org.example.MainCode.SQLIntepreter.Expression;

import org.example.MainCode.SQLIntepreter.AcceptASTVisitor;
import org.example.MainCode.SQLIntepreter.AstVisitor;

public class TableExpression implements AcceptASTVisitor {
    public  String tableName;
    public  String alias;

    public TableExpression(String tableName, String alias) {
        this.tableName = tableName;
        this.alias = alias;
    }


    public TableExpression(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return null;
    }
}
