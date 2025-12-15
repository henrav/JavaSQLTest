package org.example.MainCode.SQLIntepreter.Expression;

import org.example.MainCode.SQLIntepreter.AstVisitor;
import org.example.MainCode.SQLIntepreter.Expression.Arithmetic.OperatorExpression;

public class WhereExpression extends BinaryExpression {


    public WhereExpression(Expression left, OperatorExpression operator, Expression right) {
        super(left, operator, right);
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitWhereClause(this);
    }

}
