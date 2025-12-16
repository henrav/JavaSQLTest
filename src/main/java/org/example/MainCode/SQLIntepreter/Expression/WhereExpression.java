package org.example.MainCode.SQLIntepreter.Expression;

import org.example.MainCode.SQLIntepreter.AstVisitor;

public class WhereExpression extends BinaryExpression {


    public WhereExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitWhereClause(this);
    }

}
