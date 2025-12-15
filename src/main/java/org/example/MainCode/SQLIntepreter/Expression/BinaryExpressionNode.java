package org.example.MainCode.SQLIntepreter.Expression;

import org.example.MainCode.SQLIntepreter.AstVisitor;
import org.example.MainCode.SQLIntepreter.Expression.Arithmetic.OperatorExpressionNode;

public class BinaryExpressionNode extends ExpressionNode {

    private  ExpressionNode left;
    private  OperatorExpressionNode operator;
    private  ExpressionNode right;

    public BinaryExpressionNode(ExpressionNode left, OperatorExpressionNode operator, ExpressionNode right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) {
        return visitor.visitBinaryExpressionNode(this);
    }

    public ExpressionNode getLeft() {
        return left;
    }

    public OperatorExpressionNode getOperator() {
        return operator;
    }

    public ExpressionNode getRight() {
        return right;
    }
    public void setLeft(ExpressionNode left) {
        this.left = left;
    }

    public void setOperator(OperatorExpressionNode operator) {
        this.operator = operator;
    }

    public void setRight(ExpressionNode right) {
        this.right = right;
    }


}