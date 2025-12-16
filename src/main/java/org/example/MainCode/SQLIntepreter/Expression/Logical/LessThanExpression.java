package org.example.MainCode.SQLIntepreter.Expression.Logical;

import org.example.MainCode.SQLIntepreter.AstVisitor;
import org.example.MainCode.SQLIntepreter.Expression.BinaryExpression;
import org.example.MainCode.SQLIntepreter.Expression.Expression;

public class LessThanExpression  extends BinaryExpression {
    public LessThanExpression(Expression left, Expression right) {
        super(left, right);
    }

    public LessThanExpression() {
        super();
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitLessThanExpression(this);
    }
}
