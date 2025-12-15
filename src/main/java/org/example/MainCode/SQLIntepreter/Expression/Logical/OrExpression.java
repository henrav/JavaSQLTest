package org.example.MainCode.SQLIntepreter.Expression.Logical;

import org.example.MainCode.SQLIntepreter.AstVisitor;
import org.example.MainCode.SQLIntepreter.Expression.BinaryExpression;
import org.example.MainCode.SQLIntepreter.Expression.Expression;

public class OrExpression extends BinaryExpression {
    public OrExpression(Expression left, Expression right) {
        super(left, right);
    }
    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitOrExpression(this);
    }
}
