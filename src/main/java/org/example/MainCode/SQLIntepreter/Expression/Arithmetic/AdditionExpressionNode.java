package org.example.MainCode.SQLIntepreter.Expression.Arithmetic;

import org.example.MainCode.SQLIntepreter.AstVisitor;
import org.example.MainCode.SQLIntepreter.Expression.ExpressionNode;

public class AdditionExpressionNode extends OperatorExpressionNode {
    @Override
    public <R> R accept(AstVisitor<R> visitor) {
       return visitor.visitAdditionExpressionNode(this);
    }
}
