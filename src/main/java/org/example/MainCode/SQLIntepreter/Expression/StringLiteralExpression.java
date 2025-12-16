package org.example.MainCode.SQLIntepreter.Expression;

import org.example.MainCode.SQLIntepreter.AstVisitor;

public class StringLiteralExpression extends Expression {
    public String string;


    public StringLiteralExpression(String string) {
        this.string = string;
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitStringLiteralNode(this);
    }
}
