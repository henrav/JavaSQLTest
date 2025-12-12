package org.example.MainCode.SQLIntepreter.Expression;

import org.example.MainCode.SQLIntepreter.AcceptASTVisitor;
import org.example.MainCode.SQLIntepreter.AstVisitor;

public class TableNode implements AcceptASTVisitor {
    private final String name;

    public TableNode(String name) {
        this.name = name;
    }

    public String getName(){ return name;}

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return null;
    }
}
