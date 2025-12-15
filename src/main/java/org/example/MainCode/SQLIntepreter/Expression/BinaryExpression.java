package org.example.MainCode.SQLIntepreter.Expression;

import org.example.MainCode.SQLIntepreter.AstVisitor;

public abstract class BinaryExpression extends Expression {

    private Expression left;
    private Expression right;

    public BinaryExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitBinaryExpressionNode(this);
    }

    public Expression getLeft() {
        return left;
    }



    public Expression getRight() {
        return right;
    }
    public void setLeft(Expression left) {
        this.left = left;
    }



    public void setRight(Expression right) {
        this.right = right;
    }


}