package org.example.MainCode.SQLIntepreter.Expression;

import org.example.MainCode.SQLIntepreter.AstVisitor;

public class StringLiteralNode implements ExpressionNode {
    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitStringLiteralNode(this);
    }
}
