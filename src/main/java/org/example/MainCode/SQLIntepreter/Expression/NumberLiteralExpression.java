package org.example.MainCode.SQLIntepreter.Expression;


import org.example.MainCode.SQLIntepreter.AstVisitor;

public class NumberLiteralExpression extends Expression {
    private final double value;
    public NumberLiteralExpression(double value) { this.value = value; }
    public NumberLiteralExpression(String value) { this.value = Double.parseDouble(value); }
    public double getValue() { return value; }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitNumberLiteralNode(this);
    }
}