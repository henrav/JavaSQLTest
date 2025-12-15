package org.example.MainCode.SQLIntepreter.Expression;

import org.example.MainCode.SQLIntepreter.AstVisitor;

public class IdentifierExpression extends Expression {
    private final String name;
    public IdentifierExpression(String name) { this.name = name; }
    public String getName() { return name; }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitIdentifierExpressionNode(this);
    }
}
