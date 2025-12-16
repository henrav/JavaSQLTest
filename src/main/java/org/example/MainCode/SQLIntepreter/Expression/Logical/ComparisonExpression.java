package org.example.MainCode.SQLIntepreter.Expression.Logical;

import org.example.MainCode.SQLIntepreter.AstVisitor;
import org.example.MainCode.SQLIntepreter.Expression.BinaryExpression;
import org.example.MainCode.SQLIntepreter.Expression.Expression;

public class ComparisonExpression extends BinaryExpression {
    public ComparisonExpression(Expression left, Expression right) {
        super(left, right);
    }

    public ComparisonExpression() {
        super();
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitComparisonExpression(this);
    }
}
