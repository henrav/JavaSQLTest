package org.example.MainCode.SQLIntepreter.Expression;

import org.example.MainCode.SQLIntepreter.AstVisitor;
import org.example.MainCode.SQLIntepreter.JoinType;

public class JoinExpression extends Expression{

    public JoinType type;
    public TableExpression table;

    public Expression expression;


    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return null;
    }
}
