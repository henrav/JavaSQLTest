package org.example.MainCode.SQLIntepreter.Expression.Logical;

import org.example.MainCode.SQLIntepreter.AstVisitor;
import org.example.MainCode.SQLIntepreter.Expression.BinaryExpression;
import org.example.MainCode.SQLIntepreter.Expression.Expression;

public class GreaterThanExpression  extends BinaryExpression {
    public GreaterThanExpression(Expression left, Expression right) {
        super(left, right);
    }

    public GreaterThanExpression() {
        super();
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitGreaterThanExpression(this);
    }
}
