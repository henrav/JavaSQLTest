package org.example.MainCode.SQLIntepreter.Expression.Arithmetic;

import org.example.MainCode.SQLIntepreter.AstVisitor;
import org.example.MainCode.SQLIntepreter.Expression.BinaryExpression;
import org.example.MainCode.SQLIntepreter.Expression.Expression;

public class AdditionExpression extends BinaryExpression {
    public AdditionExpression(Expression left , Expression right) {
        super(left, right);
    }

    public AdditionExpression() {

    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
       return visitor.visitAdditionExpressionNode(this);
    }
}
