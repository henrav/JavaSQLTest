package org.example.MainCode.SQLIntepreter.Expression.Arithmetic;

import org.example.MainCode.SQLIntepreter.AstVisitor;

public class SubtractionExpressionNode extends OperatorExpressionNode{
    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitSubtractionExpressionNode(this);
    }
}
