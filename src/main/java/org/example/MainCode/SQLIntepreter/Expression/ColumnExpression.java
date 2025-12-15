package org.example.MainCode.SQLIntepreter.Expression;

import org.example.MainCode.SQLIntepreter.AstVisitor;

public class ColumnExpression extends Expression{

    public String table;
    public String column;
    public ColumnExpression(String table, String column) {
        this.table = table;
        this.column = column;
    }
    public ColumnExpression(String column) {
        this.column = column;
    }


    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return null;
    }
}
