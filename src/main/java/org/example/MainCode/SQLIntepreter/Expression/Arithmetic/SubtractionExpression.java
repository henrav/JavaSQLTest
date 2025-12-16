package org.example.MainCode.SQLIntepreter.Expression.Arithmetic;

import org.example.MainCode.SQLIntepreter.AstVisitor;
import org.example.MainCode.SQLIntepreter.Expression.BinaryExpression;
import org.example.MainCode.SQLIntepreter.Expression.Expression;

public class SubtractionExpression extends BinaryExpression {
    public SubtractionExpression(Expression left , Expression right) {
        super(left, right);
    }

    public SubtractionExpression() {
        super();
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitSubtractionExpressionNode(this);
    }
}
