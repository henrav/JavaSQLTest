package org.example.MainCode.SQLIntepreter.Expression;


import org.example.MainCode.SQLIntepreter.AstVisitor;

public class NumberLiteralNode implements ExpressionNode {
    private final double value;
    public NumberLiteralNode(double value) { this.value = value; }
    public double getValue() { return value; }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitNumberLiteralNode(this);
    }
}